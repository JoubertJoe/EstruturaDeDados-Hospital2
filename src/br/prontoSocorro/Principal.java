package br.prontoSocorro;

import br.prontoSocorro.data.Estruturas;
import br.prontoSocorro.gui.JanelaAdministracao;
import br.prontoSocorro.gui.Launcher;
import br.prontoSocorro.gui.ProntoSocorro;

public class Principal {

	public static void main(String[] args) {
		Estruturas estrutura = new Estruturas();
		estrutura.lerDoArquivo();
		Launcher launcher = new Launcher(estrutura);

	}

}
