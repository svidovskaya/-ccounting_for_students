<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>


    <table>

        <tr>
            <td>QR_START: </td><td>

                    <#list coupQrs as coupQr>

                        <img src=${coupQr.name_start} width="148" height="148" border="0" name="QR" title="QR">
                        <a href="/panel/coupNow/${coupQr.getCouples().getId()}" >${coupQr.getCouples().getId()} </a>
                    </#list>
                </td>
        </tr>



        <tr><td>  <input type="hidden" name="_csrf" value="${_csrf.token}" /></td><td></td></tr>
    </table>

<#--    <img src="http://qrcoder.ru/code/?http%3A%2F%2F192.168.1.2%3A8080%2Fpanel&4&0" width="148" height="148" border="0" name="QR" title="QR">-->


