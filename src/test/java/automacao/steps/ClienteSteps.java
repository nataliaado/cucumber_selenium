package automacao.steps;

import org.junit.Assert;

import automacao.commons.Utils;
import automacao.pages.ClientePage;
import automacao.pages.LoginPage;
import automacao.pages.MenusPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ClienteSteps {

	ClientePage clientePage = new ClientePage();
	MenusPage menusPage = new MenusPage();
	LoginPage loginPage = new LoginPage();

	@Dado("^efetuei login no sistema utilizando o usuario (.*) e a senha (.*)$")
	public void efetuarLogin(String strUsuario, String strSenha) throws Throwable {
		loginPage.efetuarLogin(strUsuario, strSenha);
	}

	@E("^acessei o menu Clientes >> Inserir$")
	public void acessarMenuClientesInserir() throws Throwable {
		menusPage.acessarMenuClientesInserir();
	}

	@Quando("^na tela de Identificacao informo os dados de Pessoa Fisica: (.*), (.*), (.*), (.*) e (.*)$")
	public void informarDadosIdentificacaoPF(String strNome, String strEmail, String strData_nascimento, String strSexo,
			String strEstado_civil) throws Throwable {
		clientePage.informarIdentificacaoPF(strNome, strEmail, strData_nascimento, strSexo, strEstado_civil);
		Utils.logPrint("Dados de Identificacao");
	}

	@Quando("^na tela de Identificacao informo os dados de Pessoa Juridica: (.*) e (.*)$")
	public void informarDadosIdentificacaoPJ(String strRazaoSocial, String strEmail) throws Throwable {
		clientePage.informarIdentificacaoPJ(strRazaoSocial, strEmail);
		Utils.logPrint("Dados de Identificacao");
	}

	@E("^na tela de Identificacao clico em Avancar$")
	public void clicarAvancar() throws Throwable {
		clientePage.clicarAvancar();
	}

	@E("^na tela enderecos informo os enderecos$")
	public void informarEnderecos() throws Throwable {
		clientePage.informarEnderecos();
		Utils.logPrint("Enderecos");
	}

	@E("^na tela enderecos clico em Salvar$")
	public void clicarSalvar() throws Throwable {
		clientePage.clicarSalvar();
		Utils.wait(1);
		Utils.logPrint("Cliente Cadastrado");
	}

	@Entao("^na tela enderecos sera exibida mensagem de sucesso$")
	public void verificarMensagemSucesso() throws Throwable {
		boolean blnExibiuMensagemSucesso = clientePage.verificarMensagemSucesso();

		if (blnExibiuMensagemSucesso) {
			Utils.logPass("Cliente Cadastrado com sucesso");
		} else {
			Utils.logFail("Erro ao cadastrar o cliente");
		}
		Assert.assertTrue("N�o exibiu a mensagem de Sucesso", blnExibiuMensagemSucesso);
	}

	@Entao("^a tela dados de Identificacao deve ser exibida na tela$")
	public void verificarExibicaoTelaDadosIdentificacao() {
		boolean blnExibiuMensagemSucesso = clientePage.verificarExibicaoTelaDadosIdentificacao();
		if (blnExibiuMensagemSucesso) {
			Utils.logPass("Tela de Dados de Identifica��o exibida com sucesso");
		} else {
			Utils.logFail("Erro ao exibir a tela de Dados de Identificacao");
		}
		Assert.assertTrue("N�o exibiu a tela Dados de Identificacao", blnExibiuMensagemSucesso);
	}

}
