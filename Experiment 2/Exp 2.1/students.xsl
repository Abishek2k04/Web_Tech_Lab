<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
    <html>
      <head>
        <title>Student Details</title>
        <style>
          body { font-family: Arial, sans-serif; background: #f9f9f9; }
          table { border-collapse: collapse; width: 60%; margin: 20px auto; }
          th, td { border: 1px solid black; padding: 8px; text-align: center; }
          th { background-color: #a2c4c9; }
        </style>
      </head>
      <body>
        <h2 style="text-align:center;">Student Information</h2>
        <table>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
          </tr>
          <xsl:for-each select="/students/student">
            <tr>
              <td><xsl:value-of select="@id"/></td>
              <td><xsl:value-of select="name"/></td>
              <td><xsl:value-of select="age"/></td>
              <td><xsl:value-of select="email"/></td>
            </tr>
          </xsl:for-each>
        </table>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
