RAMA: MASTER INSTRUCCIONES DE USO
######################################################################################## 
Con el siguiente endpoint crear una noticia (news) 

POST: create news (crear una noticia)
http://localhost:8080/news

{
  "title": "Ultimas noticias",
  "url": "https://spacenews.com/legislation-would-make-spaceports-eligible-for-tax-exempt-bonds/",
  "imageUrl": "https://i0.wp.com/spacenews.com/wp-content/uploads/2022/01/capecanaveral-fromspace.jpg",
  "newsSite": "SpaceNews",
  "summary": "Legislation introduced in Congress Feb. 28 would give spaceports the same ability as airports and seaports to issue tax-exempt bonds",
  "featured": true,
  "events": [
    {
      "provider": "test"
    }
  ],
  "launches": [
    {
      "provider": "854c7a99-95eb-4c9b-82fe-a011546c5619"
    }
  ]
}

######################################################################################## 
OBTENER UNA NOCTICIA POR TITULO

GET: get a news (Obtener una noticia por titulo)
http://localhost:8080/news/title/{title}

######################################################################################## 
OBTENER UNA NOCTICIA POR ID

GET: get a news (Obtener una noticia por ID)
http://localhost:8080/news/{id}

############################################################################################
BORRAR UNA NOCTICIA POR ID

http://localhost:8080/news/{id}
DELETE: get a news (Obtener una noticia por ID)

############################################################################################
OBTENER UNA LISTA DE NOCTICIAS 

GET: get news (Obtener una lista de noticias)
http://localhost:8080/news

############################################################################################
ACTUALIZAR NOTICIA
SOLO ENVIAR ID DE LAUNCHES Y EVENT SI SE DESEA CAMBIAR EL PROVIDER, SINO NO ENVIAR ID

PUT: put news (ACTUALIZAR una noticia)
http://localhost:8080/news/{id}

{
    "title": "TEST",
    "url": "TEST",
    "imageUrl": "TEST",
    "newsSite": "TES",
    "summary": "TEST",
    "featured": false,
    "events": [
        {
            "eventId": "7ad14f57-ea78-4b96-b3ed-233ae610aa82",
            "provider": "PRUEBA"
        }
    ],
    "launches": [
        {
            "launchId": "57e3b57a-5a48-449e-9322-4d3900263443",
            "provider": "PRUEBA"
        }
    ]
}

############################################################################################


Para ver la data de la BBDD: Se debe levantar el proyecto, ya configurado por defecto tiene el puerto 8080, se inicializa la consola en el siguiente endpoint:
http://localhost:8080/h2-console
user:sa 
Password:

############################################################################################

SE AGREGA OPENAPI

############################################################################################

TECNOLOGIAS: JDK11, GRADLE 2.6.7

############################################################################################
