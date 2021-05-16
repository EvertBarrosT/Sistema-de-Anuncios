package SistemaDeAnuncios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Main {
	
	// Vari�veis globais e instancia de objetos e classes.
	public static Scanner leia = new Scanner(System.in);
	public static ArrayList<Anuncio> listaAnuncio = new ArrayList<>();
	public static Anuncio anuncio;

	public static void main(String[] args) {
		
		// Chamando m�todo e solicitando dados 
		interfaceSistema();
		int resposta = leia.nextInt();
		
		// Estrutura condicional de repeti��o da interface do programa.
		do {
			
			// Verificar dados informados pelo usu�rio. 
			switch (resposta) {
			case 1:
				// Chamando m�todo e atribuindo a vari�vel, tamb�m adicionando ao Array.
				anuncio = cadastroAnuncio();
				listaAnuncio.add(anuncio);
				break;
			case 2:
				// Chamando m�todo para pesquisa e impress�o de relat�rio.
				filtrarRelatorio();
				break;
			default:
				// Tela de erro.
				System.out.println("\nNumero informado inv�lido.");
				break;
			}
			
			// Chamando m�todo e solicitando dados 
			interfaceSistema();
			resposta = leia.nextInt();

		} while (resposta != 3);
		System.out.println("-- Aplica��o Encerrada --");
		leia.close();
	}
	
	// M�todo para impress�o da interface do programa
	public static void interfaceSistema() {
		System.out.println("\n-- Sistema de An�ncios --");
		System.out.println("1 - Cadastrar an�ncio");
		System.out.println("2 - Gerar relat�rio");
		System.out.println("3 - Fechar aplica��o");
		System.out.print("Selecione uma op��o: ");
	}
	
	// M�todo que realiza o cadastro.
	public static Anuncio cadastroAnuncio() {
		// Vari�veis
		String nomeAnuncio, cliente, inicio, termino;
		double investimentoPorDia;
		Date dataInicio, dataTermino;
		
		// Solicitando dados ao usu�rio 
		System.out.println("\n-- Cadastro --");
		System.out.println("Informe o nome do an�ncio: ");
		nomeAnuncio = leia.next();
		System.out.println("Informe qual o cliente: ");
		cliente = leia.next();
		System.out.println("Informe qual a data de in�cio das publica��es no formato - dd/mm/aaaa: ");
		inicio = leia.next();
		System.out.println("Informe qual a data do termino das publica��es no formato - dd/mm/aaaa: ");
		termino = leia.next();
		System.out.println("Informe qual valor vai investir por dia: ");
		investimentoPorDia = leia.nextDouble();
		
		// Declarando um tratamento de exce��o.
		try {
			
			// Declarando classe para formata��o de data.
			SimpleDateFormat simplificarData = new SimpleDateFormat("dd/MM/yyyy");
			
			// Formatando data e atribuindo a uma vari�vel.
			dataInicio = simplificarData.parse(inicio);
			dataTermino = simplificarData.parse(termino);
			
			// Chamando o m�todo para verificar se as datas informadas est�o dentro de um intervalo correto.  
			boolean condicao = verificaData(dataInicio, dataTermino);
			
			// Verificando o estado da vari�vel.
			if (condicao) {
				System.out.println("\nData de termino est� maior que data de inicio, gerar novo cadastro.");
				return null;
			}
			
		} catch (Exception ex) {
			// Informando na tela que a convers�o das datas deram errado. 
			System.out.println("\nFormato das datas informadas est�o inv�lidos, gerar novo cadastro.");
			return null;
		}
		
		// Instanciando objeto.
		Anuncio anuncio = new Anuncio(nomeAnuncio, cliente, dataInicio, dataTermino, investimentoPorDia);
		
		System.out.println("Cadastro concluido.");
		
		// Retornando objeto.
		return anuncio;
	}

	// M�todo para pesquisar e imprimir relat�rio a partir da pesquisa.
	public static void filtrarRelatorio() {
		
		// Verificando se houve algum cadastro.
		if (listaAnuncio.size() == 0) {
			// Tela de erro.
			System.out.println("N�o possui nenhuma cadastro a ser pesquisado.");
			return;
		}
		
		// Declarando classe para formata��o de data.
		SimpleDateFormat simplificarData = new SimpleDateFormat("dd/MM/yyyy");
		
		// Iniciando vari�veis locais 
		int maximoVisualizacao = 0, maximoCliques = 0, maximoCompartilhamento = 0, condicao1 = 0, condicao2 = 0, condicao3 = 0;
		String nomeCliente, inicio, termino, nomeAnuncios = "";
		double valorTotalInvestido = 0;
		Date dataI, dataT;
		
		// Solicitando dados ao usu�rio 
		System.out.println("\n-- Filtro --");
		System.out.println("Digite o nome do cliente que deseja pesquisar: ");
		nomeCliente = leia.next();
		System.out.println("Informe qual a data de in�cio deseja pesquisar no formato - dd/mm/aaaa: ");
		inicio = leia.next();
		System.out.println("Informe qual a data do termino deseja pesquisar no formato - dd/mm/aaaa: ");
		termino = leia.next();
		
		// Declarando um tratamento de exce��o.
		try {
			
			// Formatando data e atribuindo a uma vari�vel.
			dataI = simplificarData.parse(inicio);
			dataT = simplificarData.parse(termino);
			
			// Chamando o m�todo para verificar se as datas informadas est�o dentro de um intervalo correto.  
			boolean condicao = verificaData(dataI, dataT);
			
			// Verificando o estado da vari�vel.
			if (condicao) {
				System.out.println("\nData de termino est� maior que data de inicio, realizar nova pesquisa.");
				return;
			}
			
		} catch (Exception ex) {
			// Tela de erro.
			System.out.println("\nFormato das datas informadas est�o inv�lidos, gerar novo cadastro.");
			return;
		}
		
		// Estrutura condicional de repeti��o para correr todo o Array.
		for (Anuncio a : listaAnuncio) {
			
			// Verificando se o nome informado pelo usu�rio para pesquisa � o mesmo do objeto.
			if ( nomeCliente.equals(a.getCliente()) ) {
				
				// Chamando m�todo para atribuir dados as vari�veis privadas da classe.
				a.setVariaveisFiltro(dia(dataI), dia(dataT), mes(dataI), mes(dataT), ano(dataI), ano(dataT), dataI, dataT);
				
				// Chamando m�todo dentro do condicional para verificar intervalo de data informada pelo usu�rio.
				if(a.chamadaDoFiltro()) {
					
					// Condi��o para verificar se j� houve a impress�o do primeiro an�ncio do cliente pesquisado. 
					if (condicao1 != 0 ) {
						
						// Atribuindo nomes de an�ncios a vari�vel.
						nomeAnuncios += ((", ") + a.getNomeAnuncio());
						
					}else {
						
						// Atribuindo nomes de an�ncios a vari�vel.
						nomeAnuncios += a.getNomeAnuncio();
						
					}
					
					// Realizando a soma de todas as vari�veis necess�rias para impress�o do relat�rio.
					maximoVisualizacao += a.getTotalVisualizacao();
					maximoCliques += a.getTotalCliques();
					maximoCompartilhamento += a.getTotalCompartilhamento();
					valorTotalInvestido += a.getTotalInvestimento();
					condicao1 = 1;
					condicao2 = 1;
					
				}else {
					condicao3++;
				}
			}
		}
			
		//  Condi��o que verifica se algum intervalo informado pelo usu�rio corresponde ao do cliente.
		if (condicao3 == listaAnuncio.size()){
			
			// Tela de erro
			System.out.println("Intervalo de datas informadas para pesquisar inv�lida.");
			return;
		}
		
		//  Condi��o que verifica se foi encontrado algum cliente.
		if (condicao2 == 0) {
			
			// Tela de erro
			System.out.println("Cliente n�o cadrastrado no sistema.");
			return;
		}
		
		// Realiza a impress�o do relat�rio. 
		System.out.println("\n-------------- Relat�rio --------------" + 
		                   "\n\nCliente: " + nomeCliente + 
		                   "\nData: " + "Inicio: " + inicio + 
		                   "\n      Termino: " + termino +
				           "\nAn�ncios: " + nomeAnuncios + "\n\n" + 
				           "        Valor total investido: R$ " + valorTotalInvestido + "\n" +  
				           "        Max�mo de visualiza��es: " + maximoVisualizacao + "\n" + 
				           "        Max�mo de cliques: " + maximoCliques + "\n" + 
				           "        Max�mo de compartilhamentos: " + maximoCompartilhamento);
		
	}
	
	// M�todo que verifica se a data informada est� dentro dos padr�es.  
	public static boolean verificaData(Date dataInicio, Date dataTermino) {
		// Formatando data e convertendo para valores inteiros.
		SimpleDateFormat simplificarData = new SimpleDateFormat("dd");
		int diaInicio = Integer.parseInt(simplificarData.format(dataInicio));
		int diaTermino = Integer.parseInt(simplificarData.format(dataTermino));
		
		SimpleDateFormat simplificarData2 = new SimpleDateFormat("MM");
		int mesInicio = Integer.parseInt(simplificarData2.format(dataInicio));
		int mesTermino = Integer.parseInt(simplificarData2.format(dataTermino));
		
		SimpleDateFormat simplificarData3 = new SimpleDateFormat("yyyy");
		int anoInicio = Integer.parseInt(simplificarData3.format(dataInicio));
		int anoTermino = Integer.parseInt(simplificarData3.format(dataTermino));
		
		// Condi��o que verifica se data estar no padr�o correto.
		if ( ((diaTermino < diaInicio && mesTermino <= mesInicio) || (mesTermino < mesInicio && anoTermino <= anoInicio)) || (((diaInicio == diaTermino && mesInicio == mesTermino) && (anoTermino < anoInicio)) || (anoTermino < anoInicio)) ) {
			return true;
		}else {
			return false;
		}
	}

	// M�todos para formata data separando dia, m�s e ano. 
	public static int dia(Date data) {
		SimpleDateFormat simplificarData = new SimpleDateFormat("dd");
		return Integer.parseInt(simplificarData.format(data));
	}
	
	public static int mes(Date data) {
		SimpleDateFormat simplificarData = new SimpleDateFormat("MM");
		return Integer.parseInt(simplificarData.format(data));
	}
	
	public static int ano(Date data) {
		SimpleDateFormat simplificarData = new SimpleDateFormat("yyyy");
		return Integer.parseInt(simplificarData.format(data));
	}

}
