<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
  <xsl:param name="allReporters" select="1"/>
  <xsl:param name="reporter1" select="''"/>
  <xsl:param name="reporter1allParam" select="1"/>
  <xsl:param name="reporter1Param1" select="''"/>
  <xsl:param name="reporter1Param2" select="''"/>
  <xsl:param name="reporter1Param3" select="''"/>
  <xsl:param name="reporter1Param4" select="''"/>
  <xsl:param name="reporter1Param5" select="''"/>
  <xsl:param name="reporter1Param6" select="''"/>
  <xsl:param name="reporter1Param7" select="''"/>
  <xsl:param name="reporter1Param8" select="''"/>
  <xsl:param name="reporter1Param9" select="''"/>
  <xsl:param name="reporter1Param10" select="''"/>
  <xsl:param name="reporter2" select="''"/>
  <xsl:param name="reporter2allParam" select="1"/>
  <xsl:param name="reporter2Param1" select="''"/>
  <xsl:param name="reporter2Param2" select="''"/>
  <xsl:param name="reporter2Param3" select="''"/>
  <xsl:param name="reporter2Param4" select="''"/>
  <xsl:param name="reporter2Param5" select="''"/>
  <xsl:param name="reporter2Param6" select="''"/>
  <xsl:param name="reporter2Param7" select="''"/>
  <xsl:param name="reporter2Param8" select="''"/>
  <xsl:param name="reporter2Param9" select="''"/>
  <xsl:param name="reporter2Param10" select="''"/>
  <xsl:param name="reporter3" select="''"/>
  <xsl:param name="reporter3allParam" select="1"/>
  <xsl:param name="reporter3Param1" select="''"/>
  <xsl:param name="reporter3Param2" select="''"/>
  <xsl:param name="reporter3Param3" select="''"/>
  <xsl:param name="reporter3Param4" select="''"/>
  <xsl:param name="reporter3Param5" select="''"/>
  <xsl:param name="reporter3Param6" select="''"/>
  <xsl:param name="reporter3Param7" select="''"/>
  <xsl:param name="reporter3Param8" select="''"/>
  <xsl:param name="reporter3Param9" select="''"/>
  <xsl:param name="reporter3Param10" select="''"/>
  <xsl:param name="reporter4" select="''"/>
  <xsl:param name="reporter4allParam" select="1"/>
  <xsl:param name="reporter4Param1" select="''"/>
  <xsl:param name="reporter4Param2" select="''"/>
  <xsl:param name="reporter4Param3" select="''"/>
  <xsl:param name="reporter4Param4" select="''"/>
  <xsl:param name="reporter4Param5" select="''"/>
  <xsl:param name="reporter4Param6" select="''"/>
  <xsl:param name="reporter4Param7" select="''"/>
  <xsl:param name="reporter4Param8" select="''"/>
  <xsl:param name="reporter4Param9" select="''"/>
  <xsl:param name="reporter4Param10" select="''"/>
  <xsl:param name="reporter5" select="''"/>
  <xsl:param name="reporter5allParam" select="1"/>
  <xsl:param name="reporter5Param1" select="''"/>
  <xsl:param name="reporter5Param2" select="''"/>
  <xsl:param name="reporter5Param3" select="''"/>
  <xsl:param name="reporter5Param4" select="''"/>
  <xsl:param name="reporter5Param5" select="''"/>
  <xsl:param name="reporter5Param6" select="''"/>
  <xsl:param name="reporter5Param7" select="''"/>
  <xsl:param name="reporter5Param8" select="''"/>
  <xsl:param name="reporter5Param9" select="''"/>
  <xsl:param name="reporter5Param10" select="''"/>
  <xsl:param name="reporter6" select="''"/>
  <xsl:param name="reporter6allParam" select="1"/>
  <xsl:param name="reporter6Param1" select="''"/>
  <xsl:param name="reporter6Param2" select="''"/>
  <xsl:param name="reporter6Param3" select="''"/>
  <xsl:param name="reporter6Param4" select="''"/>
  <xsl:param name="reporter6Param5" select="''"/>
  <xsl:param name="reporter6Param6" select="''"/>
  <xsl:param name="reporter6Param7" select="''"/>
  <xsl:param name="reporter6Param8" select="''"/>
  <xsl:param name="reporter6Param9" select="''"/>
  <xsl:param name="reporter6Param10" select="''"/>
  <xsl:param name="reporter7" select="''"/>
  <xsl:param name="reporter7allParam" select="1"/>
  <xsl:param name="reporter7Param1" select="''"/>
  <xsl:param name="reporter7Param2" select="''"/>
  <xsl:param name="reporter7Param3" select="''"/>
  <xsl:param name="reporter7Param4" select="''"/>
  <xsl:param name="reporter7Param5" select="''"/>
  <xsl:param name="reporter7Param6" select="''"/>
  <xsl:param name="reporter7Param7" select="''"/>
  <xsl:param name="reporter7Param8" select="''"/>
  <xsl:param name="reporter7Param9" select="''"/>
  <xsl:param name="reporter7Param10" select="''"/>
  <xsl:param name="reporter8" select="''"/>
  <xsl:param name="reporter8allParam" select="1"/>
  <xsl:param name="reporter8Param1" select="''"/>
  <xsl:param name="reporter8Param2" select="''"/>
  <xsl:param name="reporter8Param3" select="''"/>
  <xsl:param name="reporter8Param4" select="''"/>
  <xsl:param name="reporter8Param5" select="''"/>
  <xsl:param name="reporter8Param6" select="''"/>
  <xsl:param name="reporter8Param7" select="''"/>
  <xsl:param name="reporter8Param8" select="''"/>
  <xsl:param name="reporter8Param9" select="''"/>
  <xsl:param name="reporter8Param10" select="''"/>
  <xsl:param name="reporter9" select="''"/>
  <xsl:param name="reporter9allParam" select="1"/>
  <xsl:param name="reporter9Param1" select="''"/>
  <xsl:param name="reporter9Param2" select="''"/>
  <xsl:param name="reporter9Param3" select="''"/>
  <xsl:param name="reporter9Param4" select="''"/>
  <xsl:param name="reporter9Param5" select="''"/>
  <xsl:param name="reporter9Param6" select="''"/>
  <xsl:param name="reporter9Param7" select="''"/>
  <xsl:param name="reporter9Param8" select="''"/>
  <xsl:param name="reporter9Param9" select="''"/>
  <xsl:param name="reporter9Param10" select="''"/>
  <xsl:param name="reporter10" select="''"/>
  <xsl:param name="reporter10allParam" select="1"/>
  <xsl:param name="reporter10Param1" select="''"/>
  <xsl:param name="reporter10Param2" select="''"/>
  <xsl:param name="reporter10Param3" select="''"/>
  <xsl:param name="reporter10Param4" select="''"/>
  <xsl:param name="reporter10Param5" select="''"/>
  <xsl:param name="reporter10Param6" select="''"/>
  <xsl:param name="reporter10Param7" select="''"/>
  <xsl:param name="reporter10Param8" select="''"/>
  <xsl:param name="reporter10Param9" select="''"/>
  <xsl:param name="reporter10Param10" select="''"/>
</xsl:stylesheet>