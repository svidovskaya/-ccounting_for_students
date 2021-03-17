<#include "security.ftl" >
<#import "login.ftl" as l>


<#if r="ADMIN">
    <div class="navbar-text mr-3"><a href="/panel">Панель_Преподавателя</a></div>
</#if>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

    <div class="collapse navbar-collapse" id="navbarSupportedContent">

        <ul class="navbar-nav mr-auto">        </ul>



        <#if r="ADMIN" || r="USER">

            <div class="navbar-text mr-3"><a href="/myAccount/">Мой кабинет</a> </div>
            <@l.logout />

        <#else>
            <div class="navbar-text mr-3"><a href="/registration">Зарегистрироваться</a> </div>
        </#if>





    </div>
</nav>