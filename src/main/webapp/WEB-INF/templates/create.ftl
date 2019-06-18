<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<html lang="ru">
<head>
    <title>${title}</title>
</head>
<body>
    <h2>
        ${msg}
    </h2>
    <@sf.form action="/create" method="post" modelAttribute="note">
        <div>
            <@sf.label path="title">
                Заголовок заметки
            </@sf.label>
            <@sf.input path="title"/>
            <@sf.errors path="title"/>
        </div>
        <div>
            <@sf.label path="name">
                Описание заметки
            </@sf.label>
            <@sf.input path="name"/>
            <@sf.errors path="name"/>
        </div>
        <button>Создать</button>
    </@sf.form>
</body>
</html>