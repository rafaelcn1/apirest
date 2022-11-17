# apirest
# API Rest

Estudo pela playlist 
https://www.youtube.com/watch?v=bpBRFNKg8k4&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ


#ATIVIDADES

Configurar o banco de dados
Construção do MODEL PRODUTO 
Construção do REPOSITORY extends JpaRepository, usando o atributo a classe e o tipo do id da classe, no caso a class produto e o long
Construção do CONTROLER 
https://www.youtube.com/watch?v=LmqVHTOqcxs&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ&index=2
Implementando os metodos GET e Post
	Criar uma class ProdutoResource, com anotações @RestController e @RequestMapping(value = "/api"), o value será parte da URI;
	Criar um objeto da classe Repository que foi cirada e usar a anotação @Autowired para se conectar ao banco de dados;
	
	Metodo GET = Listar uma lista de produtos em JSON, para testar usamos o postman
		Anotação @GetMapping("/produtos"), onde o "produtos" vai ser a URI
		Metodo findAll() do repository @Autowired 
		
		Para testar no postman
			criar um aba como post na url http://localhost:8080/api/produtos/
			Selecionar o metodo GET
			Na aba Headers: Key = Content-Type, Value = application/json
			Send
	
	Metodo GET = Listar um produto em JSON, para testar usamos o postman
		Anotação @GetMapping("/produto/{id}"), onde o "produto" vai ser a URI e o {id}, será o parametro que irá ser passado para retornar o id a ser buscado
		Criar um metodo para retornar um objeto, no caso o produto, passando a anotação @PathVariable, para informar que o parametro será enviar via url e passando o parametro, no caso o Long id, exemplo: public Produto findById(@PathVariable(value = "id") Long id){}
		Esse Metodo irá retornar o objeto, através do metodo findById(id).orElse(null) do repository @Autowired, se for não houver dados será retornado nulo
		
	Para testar no postman
			criar um aba como post na url http://localhost:8080/api/produto/5 ("O 5 é o id do produto")
			Selecionar o metodo GET
			Na aba Headers: Key = Content-Type, Value = application/json
			Send
	
		
	Metodo POST = Salvar um produto	
		Anotação @PostMapping("/produto/"), onde o "produto" vai ser a URI
		Criar um metodo para retornar um objeto, no caso o produto, passando a anotação @RequestBody, a requisição vai pelo corpo da requisição, então o metodo vai receber o produto
		Esse Metodo irá retornar o objeto, através do metodo .save do repository @Autowired
		
		Para testar:
		No postman: criar um aba como post na url http://localhost:8080/api/produto/
		Selecionar o metodo POST
		Na aba Headers: Key = Content-Type, Value = application/json
		Na aba body: Apenas inserir o nome, quantidade e valor: ex: {    "nome": "Iphone 9",    "quantidade": 2.00,    "valor": 5500.00 }, não precisa ID pq é gerado automatico
		Send
		   
	https://www.youtube.com/watch?v=e0ItyfvbhMw&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ&index=3
	
Implementando os métodos DELETE e PUT
https://www.youtube.com/watch?v=9FICTNWTPxs&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ&index=4
	Metodo DELETE = 
		Anotação @DeleteMapping em cima do metodo
		Metodo delete do repository @Autowired 
	
	
	Para testar no postman
	No postman: criar um aba como post na url http://localhost:8080/api/produto/
	Selecionar o metodo DELETE
		Na aba Headers: Key = Content-Type, Value = application/json
		Na aba body: Apenas inserir o nome, quantidade e valor: ex: {"id": 5,    "nome": "Iphone 9",    "quantidade": 2.00,    "valor": 5500.00 }, não precisa ID pq é gerado automatico
			Nesse caso tem que passar o ID, pois tem que ser o produto completo

	Metodo PUT = Atualizar um produto	
			Anotação @PutMapping("/produto/"), onde o "produto" vai ser a URI
			Criar um metodo para retornar um objeto, no caso o produto, passando a anotação @RequestBody, a requisição vai pelo corpo da requisição, então o metodo vai receber o produto
			Esse Metodo irá retornar o objeto, através do metodo .save, do repository @Autowired, como vai o produto completo inclusive até o ID, então será feito um merge 
			
			Para testar:
			No postman: criar um aba como post na url http://localhost:8080/api/produto/
			Selecionar o metodo PUT
			Na aba Headers: Key = Content-Type, Value = application/json
			Na aba body: Apenas inserir o nome, quantidade e valor: ex: {"id": 1,    "nome": "Novo nome",    "quantidade": 2.00,    "valor": 5500.00  }, não precisa ID pq é gerado automatico
			Send
			
Implementando o Swagger:
	https://www.youtube.com/watch?v=HX4lheDqoiA&list=PL8iIphQOyG-D2FP9wkg12AavzmVRWEcnJ&index=5
	
	Swagger é uma API on line navegavel para uso da aplicação
	
	Criar uma classe de configuração;
		Usar a anotação @Configuration, para o spring saber que é uma classe de configuração;
		Usar a anotação @EnableSwagger2 para o Spring Boot para ativar o Swagger;
	
	Criar os metodos Bean e outro metodo para chamar o metodo Bean:
		Criar o metodo produtoApi para retornar um Docket, usando a anotação @Bean;
		Criar o metdo metaInfo retornando um ApiInfo; 
		
	Definir a anotação @Api, recebendo o valor "API REST Produtos" na classe Resource, no caso ProdutoResource. Exemplo: @Api(value = "Api Rest Produtos")
	Definir a anotação @CrossOrigin(origins = "*"), o valor do parametro origins é igual a * serve ara liberar quem usarar essa API, o * faz que todo mundo possa acessar, caso queira restrigir bastar colocar o dominio, exemplo: /http://clientedaapi.com.br
	Defenir em casa metodo na classe ProdutoResource faz, atraves da anotações @ApiOperation, recebendo um value com a informação, Exemplo: @ApiOperation(value = "Lista todos os produtos cadastrados") 
	
	Para testar, no navegador abrir a url http://localhost:8080/swagger-ui.html
Soluções de problemas:

1 - Problema: 
Quando alterar o arquivo application.properties e apresentar erro Caused by: org.apache.maven.shared.filtering.MavenFilteringException: Input length = 1  no arquivo pom.xml

1 - Solução:
Clicar com o botão direito do mouse em cima do arquivo application.properties e alterar o Text file encoder para UTF-8


2 - Problema:
Erro caused by: java.lang.nullpointerexception: null at springfox.documentation.spring.web.webmvcpatternsrequestconditionwrapper.getpatterns

2 - Solução: 
Adicionar no arquivo application.properties a linha:
spring.mvc.pathmatch.matching-strategy=ant_path_matcher

3 - Problema:
	A Url http://localhost:8080/swagger-ui.html não abre na versão 3.0.0 das dependencias (maven) springfox-swagger-ui e springfox-swagger2

3 - Solução:
Baixar para a versão 2.7.0 das dependencias (maven) springfox-swagger-ui e springfox-swagger2