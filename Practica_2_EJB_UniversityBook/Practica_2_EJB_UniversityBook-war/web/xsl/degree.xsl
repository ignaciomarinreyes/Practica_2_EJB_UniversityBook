<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
 	<xsl:template match="degree">
     	<table><firstCell><xsl:value-of select="name"/></firstCell></table>
  	</xsl:template>
</xsl:stylesheet>