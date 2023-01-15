#  API REST

Link local: http://localhost:8080/swagger-ui.html
Link local banco: http://localhost:8080/h2-console

![image](https://user-images.githubusercontent.com/37228699/210102680-b0faeff8-a0fb-42f2-96a9-8decea9e19b4.png)


# Considerações:

* O parâmetro (header) Token de autorização pode ser qualquer número, exemplo 10.
* Foi utilizado o banco de dados H2 como forma rápida e simples para armanezar os dados 
* Foi utilizado o Eclipse Java EE para desenvolver a API REST
* O mesmo é um projeto maven 
* Foi foi a integração com a API para validar o CPF mas o mesmo provavelmente está fora, então deixei a chamada comentada 

# Exemplo de algumas validações: 

![image](https://user-images.githubusercontent.com/37228699/210086590-7a7b1b6b-38d4-4119-8128-54ab93a6399d.png)
![image](https://user-images.githubusercontent.com/37228699/210087108-7ef10799-49d0-48dc-97ec-0490b5880537.png)


# Estruta base do projeto:

```
votacao-app
votacao-impl
	src/main/java
		/br/com/sicredi
			votacao
				api.v1
					DTOs
					Rest	
				business
					Converters
					PautaService
					VotacaoService
				infrastructure
					Client
					Entity
					Enums
					Repository
					Config
		resources/db/migration
			V2__CREATE_TABLE
			V3__CREATE_TABLE
```

