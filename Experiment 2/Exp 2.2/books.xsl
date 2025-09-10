<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <!-- Default category filter -->
    <xsl:param name="categoryFilter" select="'all'"/>

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/books">
        <table border="1" cellpadding="5" cellspacing="0">
            <tr style="background:#2a4d69;color:white;">
                <th>Category</th>
                <th>Title</th>
                <th>Author</th>
                <th>Year</th>
                <th>Price ($)</th>
            </tr>
            <xsl:for-each select="book[$categoryFilter='all' or @category=$categoryFilter]">
                <tr>
                    <td><xsl:value-of select="@category"/></td>
                    <td><xsl:value-of select="title"/></td>
                    <td><xsl:value-of select="author"/></td>
                    <td><xsl:value-of select="year"/></td>
                    <td><xsl:value-of select="price"/></td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>
