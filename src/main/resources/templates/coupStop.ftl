<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>


    <table>

        <tr>
            <td>QR_STOP: </td><td>



                        <img src=${qr.name_stop} width="148" height="148" border="0" name="QR" title="QR">


                </td>
        </tr>



        <tr><td>  <input type="hidden" name="_csrf" value="${_csrf.token}" /></td><td></td></tr>
    </table>

<#--    <img src="http://qrcoder.ru/code/?http%3A%2F%2F192.168.1.2%3A8080%2Fpanel&4&0" width="148" height="148" border="0" name="QR" title="QR">-->


