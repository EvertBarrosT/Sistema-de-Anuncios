/* Autor: Evert Barros Tavares
 * Data: 15/05/2021
 * Descrição: Sistema que permita o cadastro de anúncios e fornecerá os relatórios de cada anúncio. */

package SistemaDeAnuncios;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Main {
	
	// Variáveis globais e instancia de objetos e classes.
	public static Scanner leia = new Scanner(System.in);
	public static Scanner leiaString = new Scanner(System.in);
	public static ArrayList<Anuncio> listaAnuncio = new ArrayList<>();
	public static Anuncio anuncio;

	public static void main(String[] args) {
		
		// Chamando método e solicitando dados 
		interfaceSistema();
		int resposta = leia.nextInt();
		
		// Estrutura condicional de repetição da interface do programa.
		do {
			
			// Verificar dados informados pelo usuário. 
			switch (resposta) {
			case 1:
				// Chamando método e atribuindo a variável, também adicionando ao Array.
				anuncio = cadastroAnuncio();
				listaAnuncio.add(anuncio);
				break;
			case 2:
				// Chamando método para pesquisa e impressão de relatório.
				filtrarRelatorio();
				break;
			default:
				// Tela de erro.
				System.out.println("\n Número informado inválido.");
				break;
			}
			
			// Chamando método e solicitando dados 
			interfaceSistema();
			resposta = leia.nextInt();

		} while (resposta != 3);
		System.out.println("-- Aplicação Encerrada --");
		leia.close();
	}
	
	// Método para impressão da interface do programa
	public static void interfaceSistema() {
		System.out.println("\n-- Sistema de Anúncios --");
		System.out.println("1 - Cadastrar anúncio");
		System.out.println("2 - Gerar relatório");
		System.out.println("3 - Fechar aplicação");
		System.out.print("Selecione uma opção: ");
	}
	
	// Método que realiza o cadastro.
	public static Anuncio cadastroAnuncio() {
		// Variáveis
		String nomeAnuncio, cliente, inicio, termino;
		double investimentoPorDia;
		Date dataInicio, dataTermino;
		
		// Solicitando dados ao usuário 
		System.out.println("\n-- Cadastro --");
		System.out.println("Informe o nome do anúncio: ");
		nomeAnuncio = leiaString.nextLine();
		System.out.println("Informe qual o cliente: ");
		cliente = leiaString.nextLine();
		System.out.println("Informe qual a data de início deseja pesquisar no formato - dd/mm/aaaa: ");
		inicio = leiaString.nextLine();;
		System.out.println("Informe qual a data do término deseja pesquisar no formato - dd/mm/aaaa: ");
		termino = leiaString.nextLine();;
		System.out.println("Informe o valor investido por dia: ");
		investimentoPorDia = leia.nextDouble();
		
		// Declarando um tratamento de exceção.
		try {
			
			// Declarando classe para formatação de data.
			SimpleDateFormat simplificarData = new SimpleDateFormat("dd/MM/yyyy");
			
			// Formatando data e atribuindo a uma variável.
			dataInicio = simplificarData.parse(inicio);
			dataTermino = simplificarData.parse(termino);
			
			// Chamando o método para verificar se as datas informadas estão dentro de um intervalo correto.  
			boolean condicao = verificaData(dataInicio, dataTermino);
			
			// Verificando o estado da variável.
			if (condicao) {
				System.out.println("\n Data de término está maior que data de inicio, realizar novo cadastro.");
				return null;
			}
			
		} catch (Exception ex) {
			// Informando na tela que a conversão das datas deram errado. 
			System.out.println("\n Formato das datas informadas estão inválidas, gerar novo cadastro.");
			return null;
		}
		
		// Instanciando objeto.
		Anuncio anuncio = new Anuncio(nomeAnuncio, cliente, dataInicio, dataTermino, investimentoPorDia);
		
		System.out.println("\n --- Cadastro concluído ---");
		
		// Retornando objeto.
		return anuncio;
	}

	// Método para pesquisar e imprimir relatório a partir da pesquisa.
	public static void filtrarRelatorio() {
		
		// Verificando se houve algum cadastro.
		if (listaAnuncio.size() == 0) {
			// Tela de erro.
			System.out.println("Ainda não possui nenhum cadastro, realizar cadastro para que possa gerar relatórios.");
			return;
		}
		
		// Declarando classe para formatação de data.
		SimpleDateFormat simplificarData = new SimpleDateFormat("dd/MM/yyyy");
		
		// Iniciando variáveis locais 
		int maximoVisualizacao = 0, maximoCliques = 0, maximoCompartilhamento = 0, condicao1 = 0, condicao2 = 0, condicao3 = 0;
		String nomeCliente, inicio, termino, nomeAnuncios = "";
		double valorTotalInvestido = 0;
		Date dataI, dataT;
		
		// Solicitando dados ao usuário 
		System.out.println("\n-- Filtro --");
		System.out.println("Digite o nome do cliente que deseja pesquisar: ");
		nomeCliente = leiaString.nextLine();
		System.out.println("Informe qual a data de início deseja pesquisar no formato - dd/mm/aaaa: ");
		inicio = leia.next();
		System.out.println("Informe qual a data do término deseja pesquisar no formato - dd/mm/aaaa: ");
		termino = leia.next();
		
		// Declarando um tratamento de exceção.
		try {
			
			// Formatando data e atribuindo a uma variável.
			dataI = simplificarData.parse(inicio);
			dataT = simplificarData.parse(termino);
			
			// Chamando o método para verificar se as datas informadas estão dentro de um intervalo correto.  
			boolean condicao = verificaData(dataI, dataT);
			
			// Verificando o estado da variável.
			if (condicao) {
				System.out.println("\n Data de termino está maior que data de inicio, realizar nova pesquisa.");
				return;
			}
			
		} catch (Exception ex) {
			// Tela de erro.
			System.out.println("\n Formato das datas informadas estão inválidos, gerar novo cadastro.");
			return;
		}
		
		// Estrutura condicional de repetição para correr todo o Array.
		for (Anuncio a : listaAnuncio) {
			
			// Verificando se o nome informado pelo usuário para pesquisa é o mesmo do objeto.
			if ( nomeCliente.equals(a.getCliente()) ) {
				
				// Chamando método para atribuir dados as variáveis privadas da classe.
				a.setVariaveisFiltro(dia(dataI), dia(dataT), mes(dataI), mes(dataT), ano(dataI), ano(dataT), dataI, dataT);
				
				// Chamando método dentro do condicional para verificar intervalo de data informada pelo usuário.
				if(a.chamadaDoFiltro()) {
					
					// Condição para verificar se já houve a impressão do primeiro anúncio do cliente pesquisado. 
					if (condicao1 != 0 ) {
						
						// Atribuindo nomes de anúncios a variável.
						nomeAnuncios += ((", ") + a.getNomeAnuncio());
						
					}else {
						
						// Atribuindo nomes de anúncios a variável.
						nomeAnuncios += a.getNomeAnuncio();
						
					}
					
					// Realizando a soma de todas as variáveis necessárias para impressão do relatório.
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
			
		//  Condição que verifica se algum intervalo informado pelo usuário corresponde ao do cliente.
		if (condicao3 == listaAnuncio.size()){
			
			// Tela de erro
			System.out.println("Intervalo de datas informadas para pesquisar inválida.");
			return;
		}
		
		//  Condição que verifica se foi encontrado algum cliente.
		if (condicao2 == 0) {
			
			// Tela de erro
			System.out.println("Cliente não cadastrado no sistema.");
			return;
		}
		
		// Realiza a impressão do relatório. 
		System.out.println("\n-------------- Relatório --------------" + 
		                   "\n\nCliente: " + nomeCliente + 
		                   "\nData: " + "Inicio: " + inicio + 
		                   "\n      Termino: " + termino +
				           "\nAnúncios: " + nomeAnuncios + "\n\n" + 
				           "        Valor total investido: R$ " + valorTotalInvestido + "\n" +  
				           "        Maxímo de visualizações: " + maximoVisualizacao + "\n" + 
				           "        Maxímo de cliques: " + maximoCliques + "\n" + 
				           "        Maxímo de compartilhamentos: " + maximoCompartilhamento);
		
	}
	
	// Método que verifica se a data informada está dentro dos padrões.  
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
		
		// Condição que verifica se data estar no padrão correto.
		if ( ((diaTermino < diaInicio && mesTermino <= mesInicio) || (mesTermino < mesInicio && anoTermino <= anoInicio)) || (((diaInicio == diaTermino && mesInicio == mesTermino) && (anoTermino < anoInicio)) || (anoTermino < anoInicio)) ) {
			return true;
		}else {
			return false;
		}
	}

	// Métodos para formata data separando dia, mês e ano. 
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
