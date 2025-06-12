<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <botiga>
            <xsl:for-each select="//producte">
                <producte>
                    <nom>
                        <xsl:attribute name="codi"><xsl:value-of select="id"></xsl:value-of></xsl:attribute>
                        <xsl:value-of select="nom"></xsl:value-of>
                    </nom>
                    <xsl:if test="nom/@estoc='si'">
                        <estoc/>
                    </xsl:if>
                    <descripcio>
                        <xsl:value-of select="descripcio"></xsl:value-of>
                    </descripcio>
                    <preu><xsl:value-of select="preu"></xsl:value-of> euros</preu>
                </producte>
            </xsl:for-each>
        </botiga>
    </xsl:template>
</xsl:stylesheet>
