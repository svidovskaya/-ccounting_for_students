<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>

<form action="" method="post" enctype="multipart/form-data">
    <table>
        <thead>
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Группа</th>


            <th></th>
        </tr>
        </thead>
        <tbody>
       <#list users as user>
           <tr><td>${user.getUser().getUserInfo().surname}</td>
           <td>${user.getUser().getUserInfo().name}</td>
           <td>${user.getUser().getUserInfo().middlename}</td>
           <td>${user.getUser().getGroups().name}</td></tr>
       </#list>


        <tr><td>  <input type="hidden" name="_csrf" value="${_csrf.token}" /></td><td><input type="submit" value="Закончить пару"/></td></tr>
        </tbody>
    </table>



<#--    <table>-->

<#--        <tr>-->
<#--            <td>Предмет: </td><td>-->
<#--                <select name="sbjct">-->
<#--                    <#list sbjct as sbjc>-->

<#--                        <option value="${sbjc.id}"${sbjc.name}</option>${sbjc.name}-->

<#--                    </#list>-->
<#--                </select>   </td>-->
<#--        </tr>-->
<#--        <tr>-->
<#--            <td>Группа: </td><td>-->
<#--                <select name="groups">-->
<#--                    <#list groups as group>-->

<#--                        <option value="${group.id}"${group.name}</option>${group.name}-->

<#--                    </#list>-->
<#--                </select>   </td>-->
<#--        </tr>-->


<#--        <tr><td>  <input type="hidden" name="_csrf" value="${_csrf.token}" /></td><td><input type="submit" value="Создать"/></td></tr>-->
<#--    </table>-->

<#--    <img src="http://qrcoder.ru/code/?http%3A%2F%2F192.168.1.2%3A8080%2Fpanel&4&0" width="148" height="148" border="0" name="QR" title="QR">-->

</form>
