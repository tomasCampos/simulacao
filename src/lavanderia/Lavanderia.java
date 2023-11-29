package lavanderia;
import desmoj.core.dist.ContDistExponential;
import desmoj.core.dist.ContDistUniform;
import desmoj.core.simulator.Experiment;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.Queue;
import desmoj.core.simulator.TimeInstant;
import desmoj.core.simulator.TimeSpan;

public class Lavanderia extends Model{
	
	// Definição do tempo de simulação.
	private static double tempoSimulacao = 5000;
	
	/**
	 * filaClientes: variável responsável por armazenar todos os clientes
	 * que estão aguardando a máquina de lavar ser liberada para utilizarem-na.
	 */
	private Queue<Cliente> filaClientes;
	
	/**
	 * maquinaLavar: entidade responsável por servir os clientes da lavanderia,
	 * lavando suas roupas.
	 */
	private MaquinaLavar maquinaLavar;
	
	/**
	 * distribuicaoTempoChegadasClientes: distribuição do tempo entre chegadas sucessivas de
	 * clientes à lavanderia.
	 * Será usada uma distribuição exponencial, com média de 40 minutos.
	 */
	private ContDistExponential distribuicaoTempoChegadasClientes;
	
	/**
	 * distribuicaoTempoServicoMaquinaLavar: distribuição do tempo de serviço da máquina de lavar, ou seja,
	 * do tempo gasto pela máquina de lavar para servir (lavar as roupas) os clientes da lavanderia.
	 * Será usada uma distribuição uniforme, com valores entre 20 e 40 minutos.
	 */
	private ContDistUniform distribuicaoTempoServicoMaquinaLavar;
	
	/**
	    * Método construtor da Lavanderia.
	    *
	    * Cria um novo modelo, que representa o modelo de eventos discretos da lavanderia.
	    * A criação do modelo da lavanderia ocorre por meio da chamada
	    * do método construtor da super-classe, ou seja, da classe Model.
	    * 
	    * parâmetro owner: indica o modelo do qual esse modelo é parte.
	    * 				   Deve ser setado para null quando não existir um modelo,
	    *                  do qual esse novo modelo criado faz parte.
	    *                  
	    * parâmetro name: indica o nome do modelo.
	    * 
	    * parâmetro showInReport: é um flag booleano que indica se o modelo deve ou não
	    * 						  produzir saídas para um relatório da simulação.
	    *
	    * parâmetro showInTrace: é um flag que indica se o modelo deve ou não
	    *                        produzir saídas para um trace de saída.
	    */
	public Lavanderia(Model owner, String name, boolean showInReport, boolean showIntrace) {
		super (owner, name, showInReport, showIntrace);
	}
	
	@Override
	/**
	 * Método description
	 * 
	 * Retorna uma string que descreve o modelo criado.
	 * Essa descrição é automaticamente incluída 
	 * no relatório da simulação que é criado.
	 */
	public String description() {
		return ("Esse é o modelo de eventos discretos de uma lavanderia. " +
				"Clientes chegam em uma lavanderia self-service para lavarem suas roupas. " +
				"Eles esperam em uma fila do tipo FIFO até que a máquina de lavar-roupas fique disponível " +
				"para ser utilizada. " +
				"Depois que a lavagem das roupas trazidas pelo cliente termina, " +
				"o cliente deixa a lavanderia " +
				"e a máquina de lavar que foi utilizada torna-se disponível para servir o próximo cliente.");
	}
	
	@Override
	/**
	 * Método responsável por instanciar todos os componentes estáticos associados ao modelo (filas, entidades e distribuições).
	 * Assim, é necessário indicar, nesse método, todas as inicializações e instanciações necessárias.
	 * 
	 * Nesse caso, os componentes estáticos do modelo são a fila de clientes, a máquina de lavar, a distribuição
	 * do tempo entre chegadas sucessivas de clientes à lavanderia e a distribuição do tempo de serviço da máquina de lavar.
	 * 
	 * Esse método não deve ser utilizado para fazer os escalonamentos iniciais de eventos,
	 * necessários para o escalonador iniciar sua execução. O método doInitialSchedules()
	 * é que deve ser utilizado para isso.
	 */
	public void init() {
		
		/**
		 * Criação da fila de clientes aguardando sua vez de utilizarem a máquina de lavar.
		 * Parâmetros:
		 * Modelo ao qual a fila está associada.
		 * Nome da fila.
		 * Flag booleano que indica se a fila deve ou não produzir saídas para um relatório da simulação.
	     * Flag que indica se a fila deve ou não produzir saídas para um trace de saída.
	     */
		filaClientes = new Queue<Cliente> (this, "Fila de clientes aguardando serviço", true, true);
	    
		/**
		 * Criação da entidade responsável por lavar as roupas trazidas pelos clientes à lavanderia.
		 * Parâmetros:
		 * Modelo ao qual a entidade está associada.
		 * Nome da entidade.
		 * Flag que indica se a entidade deve ou não produzir saídas para um trace de saída da simulação.
	     */
		maquinaLavar = new MaquinaLavar (this, "Máquina de lavar", true);
		
		/**
		 * Criação da distribuição do tempo entre chegadas sucessivas de clientes à lavanderia.
		 * Parâmetros:
		 * Modelo ao qual a distribuição está associada.
		 * Nome da distribuição.
		 * Double que indica a média dos valores dessa distribuição de probabilidade.
		 * Flag booleano que indica se a distribuição deve ou não produzir saídas para um relatório da simulação.
	     * Flag que indica se a distribuição deve ou não produzir saídas para um trace de saída.
	     */
		distribuicaoTempoChegadasClientes = new ContDistExponential (this, "Distribuição do tempo entre chegadas sucessivas de clientes à lavanderia", 40.0, true, true);
		
		/**
		 * Método que indica se os valores gerados por essa distribuição de probabilidade podem ser negativos ou apenas positivos.
		 * 
		 * Nesse caso, como o flag foi setado para "true", a distribuição deverá retornar apenas valores positivos.
		 */
		distribuicaoTempoChegadasClientes.setNonNegative(true);

		/**
		 * Criação da distribuição do tempo de serviço da máquina de lavar.
		 * Parâmetros:
		 * Modelo ao qual a distribuição está associada.
		 * Nome da distribuição.
		 * Double que indica o limite inferior dos valores dessa distribuição de probabilidade.
		 * Double que indica o limite superior dos valores dessa distribuição de probabilidade.
		 * Flag booleano que indica se a distribuição deve ou não produzir saídas para um relatório da simulação.
	     * Flag que indica se a distribuição deve ou não produzir saídas para um trace de saída.
	     */
		
		distribuicaoTempoServicoMaquinaLavar = new ContDistUniform (this, "Distribuição do tempo de serviço da máquina de lavar roupas", 20.0, 40.0, true, true);
		
		/**
		 * Método que indica se os valores gerados por essa distribuição de probabilidade podem ser negativos ou apenas positivos.
		 * 
		 * Nesse caso, como o flag foi setado para "true", a distribuição deverá retornar apenas valores positivos.
		 */
		distribuicaoTempoServicoMaquinaLavar.setNonNegative(true);
	}
	
	@Override
	/** 
	 * Método responsável por ativar os componentes dinâmicos do modelo, ou seja, 
	 * basicamente, os eventos que iniciam a simulação.
	 * 
	 * Esse método é utilizado para escalonar todos os eventos, na lista interna de eventos 
	 * do simulador, necessários para iniciar a simulação.
	 * 
	 * Nesse caso, o evento externo gerador de clientes que chegam à lavanderia para
	 * lavarem suas roupas é criado e escalonado para ocorrer logo no início da simulação. 
     */
	public void doInitialSchedules() {
		
		EventoGeradorCliente eventoGeradorCliente;
			
		eventoGeradorCliente = new EventoGeradorCliente (this, "Evento externo responsável por gerar um cliente que chega à lavanderia", true);
		
	    /**
	     * Escalona o evento externo "eventoGeradorCliente" para ocorrer em um ponto específico da simulação.
	     * Nesse caso, o evento externo deverá ocorrer logo no início da simulação.
	     */
		eventoGeradorCliente.schedule(new TimeSpan(0.0));
	}
	
	/**
	 * Método responsável por retornar uma amostra
	 * da distribuição de probabilidade utilizada para determinar o momento de chegada,
	 * na lavanderia, do próximo cliente.
	 */
	public double getTempoEntreChegadasClientes(){
		
		return (distribuicaoTempoChegadasClientes.sample());
	}
	
	/**
	 * Método responsável por retornar uma amostra
	 * da distribuição de probabilidade utilizada para determinar
	 * o tempo de serviço da máquina de lavar-roupas.
	 */
	public double getTempoLavagem() {
		
		return (distribuicaoTempoServicoMaquinaLavar.sample());	
	}

	/**
	 * Esse método verifica se a máquina de lavar está livre para ser utilizada pelo 
	 * novo cliente (passado como parâmetro) que chegou à lavanderia ou ocupada.
	 * No primeiro caso, a máquina de lavar roupas é alocada para esse cliente.
	 * No segundo caso, esse cliente entra em uma fila de espera, onde irá aguardar
	 * a liberação da máquina de lavar roupas. 
	 */
	public void servirCliente(Cliente cliente) {
			
		/**
		 * Verifica se a máquina de lavar roupas está livre,
		 * o que indica que o novo cliente que chegou à lavanderia pode utilizá-la.
		 */
		if ((maquinaLavar.getOcupada()) == false){
			
			// Modifica o estado da máquina de lavar-roupas indicando que, a partir desse momento, ela está sendo utilizada por um cliente.
			maquinaLavar.setOcupada(true);

			// Utilização da máquina de lavar roupas pelo novo cliente que chegou à lavanderia.
			maquinaLavar.lavar(cliente);
		}else{
			/**
			 * Caso a máquina de lavar roupas esteja ocupada, lavando as roupas trazidas
			 * por outro cliente da lavanderia, o novo cliente que chegou à lavanderia
			 * entra em uma fila de espera para utilizar a máquina de lavar.
			 */
			filaClientes.insert(cliente);
		}
	}

	/**
	 * Método responsável por liberar a máquina de lavar-roupas passada como parâmetro.
	 * Caso exista algum cliente aguardando, na fila de espera, para utilizar a máquina de lavar,
	 * essa é realocada ao primeiro cliente da fila de espera.
	 */
	public void liberarMaquinaLavar(MaquinaLavar maquinaLavar) {
	
		Cliente cliente;
		
		sendTraceNote("Liberando máquina de lavar...");
		
		// Verifica se existe algum cliente aguardando na fila de espera para utilizar a máquina de lavar.
		if (filaClientes.isEmpty()){
			
			/**
			 * Caso não exista nenhum cliente aguardando para utilizar a máquina de lavar roupas,
			 * essa é liberada.
			 */
			sendTraceNote("Máquina de lavar esperando clientes...");
			maquinaLavar.setOcupada(false);
			
		}else{
			
			sendTraceNote("Máquina de lavar será realocada.");
			
			// O primeiro cliente da fila de espera para utilizar a máquina de lavar é retirado dessa fila.
			cliente = filaClientes.first();
			filaClientes.remove(cliente);
			
			// Utilização da máquina de lavar-roupas pelo primeiro cliente da fila de espera.
			maquinaLavar.lavar(cliente);
		}
	}
	
    public static void main(String[] args) {
    
		Lavanderia modeloLavanderia;
		Experiment experimento;
		
		//Criação do modelo da lavanderia.
		modeloLavanderia = new Lavanderia (null, "Modelo de uma lavanderia self-service", true, true);
		
		// Criação do experimento da lavanderia self-service.
		experimento = new Experiment ("Experimento da lavanderia");
		
		// Conecta o modelo da lavanderia ao experimento.
		modeloLavanderia.connectToExperiment(experimento);
		   
		// Determinação dos parâmetros do experimento:
		
		// Indica que, durante a simulação, uma barra de progresso deve ser mostrada.
		experimento.setShowProgressBar(true);
		
		// Indica quando a simulação deve ser interrompida.
		// Em nossa simulação, a unidade de tempo será um minuto. 
		experimento.stop(new TimeInstant(tempoSimulacao));   
		   
		// Indica o período durante o qual as informações da simulação devem ser armazenadas no trace da simulação.
		experimento.tracePeriod(new TimeInstant(0.0), new TimeInstant(tempoSimulacao));
		
		// Inicia o experimento no instante zero da simulação.
		experimento.start();

		// Gera um relatório, e outros arquivos de saída, relacionados ao modelo conectado ao experimento.
		experimento.report();

		// Interrompe todos os eventos que ainda estão escalonados e fecha todos os arquivos de saída.
		experimento.finish();
		   
	}
}