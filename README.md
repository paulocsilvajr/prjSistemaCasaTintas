# Projeto Sistema de casa de tintas

### Desenvolvido em Java 1.8, MariaDB 10.1, JDB Framework(2016.02.21) e IReport 5.6.0

Este repositório contém um projeto desenvolvido para fins acadêmicos com o propósito de aplicar o conhecimento obtido em programação em Java e banco de dados. O sistema desenvolvido tem o objetivo de criar um ambiente propício para a gestão de vendas de uma loja, pensando na sua especialidade em produção de tintas. Os recursos contidos serão detalhados em um tópico específico.

### Pré-requisitos

Instalar os seguintes programas e pacotes:

```
Java 1.8
NetBeans IDE, usado no projeto a versão 8.2
Plugins NetBeans do IReport 5.6.0
Adicionar bibliotecas do JDB Framework e IReport ao projeto.
Adicionar paleta de componentes do JDB Framework no NetBeans.
```

Para instalar o plugin do IReport 5.6.0 no NetBeans, siga os passos:

```
Menu Tools->Plugins
Downloaded->Add Plugins
Selecionar os arquivos .nbm contidos na pasta iReport-5.6.0 e confirmar(OK)
Clique no botão Install e aguardar o progresso.
```

Para instalar a paleta do JDB Framework, siga os passos:

```
Menu Tools->Palette->Swing/AWT Componentes
New Category->JDBFramework(nome da categoria)
Add from JAR->/JDB-2016.02.21.jar
Selecionar todos os componentes JDB
Selecionar a categoria criada anteriormente, JDBFramework, e concluir.
```

As bibliotecas .jar do IReport estão localizadas em iReport-5.6.0/bibliotecas. A biblioteca do JDB Framework está na raiz do projeto.

Adicionar em Libraries de seu projeto as bibliotecas do IReport e JDB Framework. Para isso clique com o botão direito sobre Libraries e Add JAR/Folder e selecione os arquivos da pasta iReport-5.6.0/bibliotecas.

O backup do banco de dados esta na pasta backup/. Deve ser criado um banco com o nome de "casa_tintas" usando collation "utf8_general_ci".

No arquivo src/sistema/Conexao.java estão contidas os dados de conexão com o banco. Foi definido como usuário "root" e senha ""(vazio), mas deve-se mudar de acordo com a necessidade. Crie também um usuário admininistrador chamado "orions"(senha a sua escolha), as view dependem desse usuario por estarem associadas a ele.

O usuário padrão do sistema é "admin" e tem por senha "123456". Este usuário é do tipo administrador. Para modificar esta senha, deve-se logar o sistema, acessar Usuários->Cadastro de Usuários, e criar um novo usuário administrador. Após esse processo, deve-se logar com o novo administrador e modificar a senha do usuário padrão.

### Arquivos

```
backup: Pasta de backup do sistema.
src: Pasta contendo todos os pacotes do sistema.
iReport-5.6.0: Pasta contendo os plugins e bibliotecas do IReport.
JDB-2016.02.21.jar: Biblioteca do JDB Framework.
```

### Recursos

```
Entrada e saída de produtos(venda e compra).
Produção de tintas.
Controle de usuários, com permissão de acesso e histórico de acões.
Controle financeiro, englobando contas a pagar, contas a receber, controle de cheques e cartões e caixa.
Relatórios administrativos.
Backup e configurações gerais do sistema.
```

### Licença

[Licença GPL](https://github.com/paulocsilvajr/prjSistemaCasaTintas/blob/master/license_gpl.txt), arquivo em anexo no repositório.

### Contato

```
Ewerton Macedo Silva - ewertonmacedo.info@gmail.com
Jonas Almeida Raymundo - jonasaraymundo@gmail.com
Patric Pauluk - patric.pauluk@outlook.com
Paulo Carvalho da Silva Junior - pauluscave@gmail.com
```
