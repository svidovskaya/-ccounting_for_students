<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>

<form action="/panel/coupCreate" method="post" enctype="multipart/form-data">
    <table>

        <tr>
            <td>Предмет: </td><td>
                <select name="sbjct">
                    <#list sbjct as sbjc>

                        <option value="${sbjc.id}"${sbjc.name}</option>${sbjc.name}

                    </#list>
                </select>   </td>
        </tr>
        <tr>
            <td>Группа: </td><td>
                <select name="groups">
                    <#list groups as group>

                        <option value="${group.id}"${group.name}</option>${group.name}

                    </#list>
                </select>   </td>
        </tr>
        <tr>
            <td>Номер пары: </td><td>
                <select name="numb_coup">

                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                    <option value="6">6</option>
                    <option value="7">7</option>
                    <option value="8">8</option>
                </select>
           </td>
        </tr>

        <tr><td>  <input type="hidden" name="_csrf" value="${_csrf.token}" /></td><td><input type="submit" value="Создать"/></td></tr>
    </table>

<#--    <img src="http://qrcoder.ru/code/?http%3A%2F%2F192.168.1.2%3A8080%2Fpanel&4&0" width="148" height="148" border="0" name="QR" title="QR">-->

</form>
