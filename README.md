<h1 align="center">
  <br>
  <img src="https://i.imgur.com/Xz2QyAV.png?1" alt="Animavita" height="250" width="250">
  <br>
</h1>

# <p align=center> Sistema de Anúncios

## Sistema que permite o cadastro de anúncios e fornece os relatórios de cada anúncio. 



<h4 align="center">  Sistema de Anúncios ✔️ Projeto Concluído  </h4> 


Tabela de conteúdos
=================
<!--ts-->
   * [Funcionalidades da Aplicação](#funcionalidades-da-aplicação)
   * [Pre-Requisitos](#pré-requisitos)
   * [Compilando e Executando o Programa](#compilando-e-executando-o-programa)
   * [Instruções de Utilização](#instruções-de-utilização)
   * [Ferramentas](#ferramentas)
   * [Autor](#autor)
<!--te-->

## Funcionalidades da Aplicação

  * Realiza cadastro de anúncios
  * Fornece relatórios
  * Filtra relatórios por intervalo de tempo e cliente

## Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
- [Eclipse](https://www.eclipse.org/downloads/) (ou uma IDE de sua preferência) 
- [WinRAR](https://www.win-rar.com/start.html?&L=0)


## Compilando e Executando o Programa


-  Entre no link do repositório do github (<https://github.com/EvertBarrosT/Sistema-de-Anuncios>)
- Faça o download do arquivo .zip do projeto.
( Code -> Download ZIP)
![enter image description here](https://i.imgur.com/4GbhaFd.png)

- Na pasta onde você fez o download do arquivo .zip, extraia ele aonde você desejar.
(Clique botão direito ->  Extrair aqui)
![enter image description here](https://i.imgur.com/Q0CWzp7.png)
- Abra o [Eclipse](https://www.eclipse.org/downloads/) (ou uma IDE de sua preferência) e criei um projeto java
(File -> New -> Project)
![enter image description here](https://i.imgur.com/skZN9Mb.png)
(Java Project -> Next -> (De o nome que desejar ao projeto, exemplo: "Sistema de Anúncio") -> Finish - > Don't Create)
![enter image description here](https://i.imgur.com/l8TBxjC.png)
![enter image description here](https://i.imgur.com/LVfP1uD.png)

- Crie um package dentro do projeto que você acabou de criar. 
Obs: A compilação e execução da aplicação só irá acontecer se package for nomeado como (SistemaDeAnuncios), com cada caractere exatamente como está dentro do parênteses. 
( Clique botão direito na pasta "src" -> New -> Package -> Nomeei como "SistemaDeAnuncios" -> Finish)
![enter image description here](https://i.imgur.com/9DvmXSX.png)
(Nomeei como "SistemaDeAnuncios" -> Finish)
![enter image description here](https://i.imgur.com/nZ6ENmJ.png)

- Vá na pasta onde você extraiu os arquivos do github selecione e copie os arquivos "Main.java" e o "Anuncio.java" depois cole os 2 no package que você acabou de criar. 
(Segure Ctrl + Clique Botão Esquerdo nos 2 arquivos que deseja -> Clique Botão Direito -> Copiar)
![enter image description here](https://i.imgur.com/ZlL6Fak.png)
Obs: Agora no [Eclipse](https://www.eclipse.org/downloads/) no package cole os arquivos.
(Clique Botão Direito no package -> Paste)
![enter image description here](https://i.imgur.com/j5MaWg0.png)

- Agora clique com o direito no arquivo Main.java dentro do package que você criou e selecione a opção "Run As' -> "Java Application", fazendo com que a IDE compile e execute a aplicação.
(Clique Botão Direito -> Run As -> Java Application)
Obs: Dê 2 cliques no console para que a tela aumente e possa visualizar melhor a aplicação.
![enter image description here](https://i.imgur.com/25aN9mm.png?1)

- Realizando todo esse procedimento a aplicação já vai está rodando na IDE através do console. 



## Instruções de Utilização

Cada solicitação de dados que for realizada ao usuário deve-se digitar o dado e dar enter para que o dado seja computado. 

- Executando o programa você irá ver uma tela pedindo para informar o que deseja realizar no momento.
  - Digite 1 se desejar realizar um cadastro de um anúncio
  - Digite 2 se desejar gerar um relatório
  - Digite 3 se desejar fechar aplicação 
![enter image description here](https://i.imgur.com/sN6mkI8.png)
- Supondo escolha da opção 1 - Cadastrar anúncio, você vai ver uma tela aonde vai estar solicitando os seguintes dados: 
  - Nome do anúncio
  - Cliente
  - Data de início da publicação
  - Data de Término da publicação
  - Valor investido por dia
![enter image description here](https://i.imgur.com/upckvYm.png)
- As datas informadas devem ser no padrão "dd/mm/aaaa' como está no exemplo mostrado.
- Depois de preencher todos os dados pode ser visto a mensagem de cadastro concluído, caso ocorra algum erro no programa ele acusará qual foi o problema. 
- Vai ser solicitado novamente o que você deseja realizar.
- Supondo a escolha da opção 2 - Gerar relatório, vai ser solicitados os seguinte dados: 
  - Cliente
  - Data de início da publicação
  - Data de Término da publicação
![enter image description here](https://i.imgur.com/LiabUSr.png)

- As datas informadas devem ser no padrão "dd/mm/aaaa" como está no exemplo mostrado e o nome do cliente para realizar a pesquisa deve estar exatamente o mesmo informado no cadastro. 

- Depois de todos os dados preenchidos vai ser gerado o relatório com:
  -  Nome do cliente pesquisado 
  - Intervalo de tempo solicitado 
  - Nome de todos os anúncios do cliente no intervalo de tempo pesquisado
  - O valor total de investimento realizado 
  - O máximo de visualizações
  - O máximo de cliques 
  - O máximo de compartilhamento. 
![enter image description here](https://i.imgur.com/qHBysU6.png)
- Ao imprimir o relatório vai ser solicitado novamente o que deseja fazer.

- Supondo que foi selecionado opção 3 - Fechar Aplicação 
![enter image description here](https://i.imgur.com/KM1zRUE.png)

- Pode ser cadastrado quantos anúncios desejar, e também gerar quantos relatórios desejar o programa vai continuar rodando até que selecione a opção 3 para finalizar a aplicação ou fechar o console ou a IDE. 

## Ferramentas

As seguintes ferramentas foram usadas na construção do projeto: 

- [Eclipse](https://www.eclipse.org/downloads/)
- [Git](https://github.com/)
- [GitHub](https://git-scm.com/) 

## Autor

<a href="https://blog.rocketseat.com.br/author/thiago/">
 <img style="border-radius: 50%;" src="https://i.imgur.com/g7aU166.png?1" width="100px;" alt=""/>
 <br />
 <sub><b>Evert Barros</b></sub></a> <a href="https://blog.rocketseat.com.br/author/thiago//" title="Rocketseat">💻</a>


Feito com dedicação e esforço por Evert Barros 👋🏽 Entre em contato!

[![\[](https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/evert-barros-327b43161/)[   ![enter image description here](https://img.shields.io/badge/Instagram-E4405F?style=for-the-badge&logo=instagram&logoColor=white) ](https://www.instagram.com/evertbarros/?hl=pt-br)[![\[](https://img.shields.io/badge/Microsoft_Outlook-0078D4?style=for-the-badge&logo=microsoft-outlook&logoColor=white)](mailto:evertbarros@hotmail.com)