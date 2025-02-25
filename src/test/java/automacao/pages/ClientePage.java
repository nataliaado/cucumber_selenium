package automacao.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import automacao.attributes.ClienteAttributes;
import automacao.commons.TestRule;
import automacao.commons.Utils;

public class ClientePage extends ClienteAttributes {

	public ClientePage() {
		PageFactory.initElements(TestRule.getDriver(), this);
	}

	public void informarIdentificacaoPF(String strNome, String strEmail, String strData_nascimento, String strSexo,
			String strEstado_civil) {
		fisica.click();
		cpf_cnpj.sendKeys(Utils.gerarDocumento("CPF"));
		nome_razaosocial.sendKeys(strNome);
		email.sendKeys(strEmail);
		data_nascimento.sendKeys(strData_nascimento.replace("/", ""));

		Select cmbSexo = new Select(sexo);
		cmbSexo.selectByVisibleText(strSexo);

		Select cmbEstadoCivil = new Select(estado_civil);
		cmbEstadoCivil.selectByVisibleText(strEstado_civil);
	}

	public void clicarAvancar() {
		avancar.click();
	}

	public void informarEnderecos() {
		// Endere�o Principal
		endp_cep.sendKeys("99130529");
		endp_endereco.sendKeys("Rua da Automacao Principal");
		endp_numero.sendKeys("123");
		endp_complemento.sendKeys("Bloco A");
		endp_cidade.sendKeys("Santa Catarina");

		Select cmbEstadoEndPrincipal = new Select(endp_estado);
		cmbEstadoEndPrincipal.selectByVisibleText("SC");
		endp_telefone.sendKeys("5133669854");
		endp_celular.sendKeys("54996583974");

		// Endere�o Cobran�a
		endc_cep.sendKeys("99134569");
		endc_endereco.sendKeys("Rua da Automacao Cobran�a");
		endc_numero.sendKeys("111");
		endc_complemento.sendKeys("Portaria 1");
		endc_cidade.sendKeys("Curitiba");

		Select cmbEstadoEndCobranca = new Select(endc_estado);
		cmbEstadoEndCobranca.selectByVisibleText("PR");
		endc_telefone.sendKeys("5133669854");
		endc_celular.sendKeys("54996583974");

	}

	public boolean verificarMensagemSucesso() {
		Utils.wait(3);
		String strMensagemExibida = mensagem.getText();
		System.out.println("Mensagem de texto exibida: " + strMensagemExibida);
		if (strMensagemExibida.contains("Cliente cadastrado com sucesso")) {
			return true;
		} else {
			return false;
		}

	}

	public void clicarSalvar() {
		salvar.click();
	}

	public void informarIdentificacaoPJ(String strRazaoSocial, String strEmail) {
		juridica.click();
		cpf_cnpj.sendKeys(Utils.gerarDocumento("CNPJ"));
		nome_razaosocial.sendKeys(strRazaoSocial);
		email.sendKeys(strEmail);

	}

	public boolean verificarExibicaoTelaDadosIdentificacao() {
		Utils.wait(2);
		int intQuantidadeItensEncontrados = TestRule.getDriver().findElements(By.id("cpf_cnpj")).size();

		if (intQuantidadeItensEncontrados > 0) {
			return true;
		} else {
			return false;
		}
	}

}
