Sistema para cadastro de anúncios

API REST para cadastro de novos anúncios e consulta dos valores cadastrados
Foi utilizado o framework SpringBoot com o banco de dados H2 para a persistência dos dados. (será necessário alterar o arquivo application.propreties na propriedade spring.datasource.url colocando o caminho onde deseja que o banco seja salvo para ser persistido)

Para executar o programa, é necessário abrir o projeto em uma IDE (a utilizada durante o desenvolvimento foi a INTELIJ) e compilar e executar o projeto.

  A API possui 6 endpoint, são eles: 
  -> List - GET(http://localhost:8080/ads) Endpoint para listar todos os anúncios cadastrados.
  
  -> Create - POST(http://localhost:8080/ads) Endpoint para cadastrar um novo anúncio enviando um JSON com o novo anuncio.
  
  -> TotalInvested - GET(http://localhost:8080/ads/invested/{id}  / http://localhost:8080/ads/invested/{id}/{days} Endpoint para retornar o valor total investido em        um anúncio. O parâmetro id é o identificador do anúncio e opcionalmente pode ser enviado o days que é quantidade de dias para limitar o cálculo por um              período específico de dias. 
  
  -> MaxViews - GET(http://localhost:8080/ads/views/{id}  /  http://localhost:8080/ads/views/{id}/{days} ) Endpoint para retornar o alcance máximo de visualizações       de um anúncio. O parâmetro id é o identificador do anúncio e opcionalmente pode ser enviado o days que é a quantidade de dias para limitar o cálculo a um           período específico de dias. 
  
  -> MaxClicks - GET(http://localhost:8080/ads/clicks/{id}  /  http://localhost:8080/ads/clicks/{id}/{days} ) Endpoint para retornar o número máximo de clicks de um        anúncio. O parâmetro id é o identificador do anúncio e opcionalmente pode ser enviado o days que é a quantidade de dias para limitar o cálculo a um período          específico de dias. 
  
  -> MaxShare - GET(http://localhost:8080/ads/share/{id}  /  http://localhost:8080/ads/share/{id}/{days} ) Endpoint para retornar o número máximo de                        compartilhamentos de um anúncio. O parâmetro id é o identificador do anúncio e opcionalmente pode ser enviado o days que é a quantidade de dias para limitar        o cálculo a um período específico de dias. 

