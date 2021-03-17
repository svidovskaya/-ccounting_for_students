<#import "parts/common.ftl" as c>
<@c.page>
</@c.page>

<form action="/coupl/" method="post" enctype="multipart/form-data">
    <table>
<tr><td>Subject: </td><td><input type="text"  name="sbj" value="${coup.sbjct.getName()}" readonly/>  </td></tr>
        <tr>
            <td></td><td>
                <input type="hidden"  name="coup" value="${coup.id}" readonly/>
            </td>
        </tr>
        <tr>
            <td>Фамилия: </td><td>
                <input type="text"  name="surname" value="${user.getUserInfo().surname}" readonly/>
                </td>
        </tr>
        <tr>a
            <td>Имя: </td><td>
                <input type="text"  name="name" value="${user.getUserInfo().name}" readonly/>
            </td>
        </tr>
        <tr>
            <td>Отчество: </td><td>
                <input type="text"  name="middlename" value="${user.getUserInfo().middlename}" readonly/>
            </td>
        </tr>




        <tr><td>  <input type="hidden" name="_csrf" value="${_csrf.token}" /></td><td><input type="submit" value="Войти"/></td></tr>
    </table>

<#--    <img src="http://qrcoder.ru/code/?http%3A%2F%2F192.168.1.2%3A8080%2Fpanel&4&0" width="148" height="148" border="0" name="QR" title="QR">-->

</form>
