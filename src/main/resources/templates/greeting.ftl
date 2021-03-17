<#import "parts/common.ftl" as c>
<#include "parts/security.ftl" >

<@c.page>

</@c.page>

Главная страница
<#if r="USER">
    <a href="/coupl/myQR">Показать мой qr код</a>
</#if>