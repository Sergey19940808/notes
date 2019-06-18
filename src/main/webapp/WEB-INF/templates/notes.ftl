<html lang="ru">
<head>
    <title>${title}</title>
</head>
<body>
    <div style="color: red;font-size: 40px; margin: 20px 350px 0 370px">
        <h1>
            <i>${msg}:</i>
        </h1>

        <form action="/notes" method="get">
            <input name="title" type="text" placeholder="Заголовок заметки">
            <input name="name" type="text" placeholder="Описание заметки">
            <button>Найти</button>
        </form>

        <div style="margin: 0 0 40px 0">
            <a style="color: cornflowerblue; text-decoration: none;" href="/create">
                Создать заметку
            </a>
        </div>

        <#if notes?has_content>
            <#list notes as note>
                <div style="width: 500px; margin-bottom: 20px; color: brown; font-size: 26px; border-radius: 10px;
                            border: 1px solid; border-color: burlywood"
                >
                    <div style="margin: 0 0 20px 40px">
                        <#if note.title??>
                            <p>Заголовок: ${note.title}</p>
                        <#else>
                            <p>Описание: ${note.name}</p>
                        </#if>
                        <a style="color: cornflowerblue; text-decoration: none;" href="/delete/${note.title}">
                            Удалить
                        </a>
                    </div>
                </div>
            </#list>
        <#else>
            <p style="color: brown; font-size: 26px; margin-left: 40px">
                Заметок пока нет
            </p>
        </#if>
    </div>
</body>
</html>