# Este projeto consiste em um CRUD em Java com JSP e possui dependências necessárias que possa ser executado.
## Abaixo segue o passo a passo:
### Configurar databse com name "crudjspjava" user "root" password "".
### Baixar o Server Apache Tomcat® na versão 8.5.69, link: https://tomcat.apache.org/download-80.cgi.

### Comando para criar a estrutura da tabela.
CREATE TABLE IF NOT EXISTS `usuario` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `sexo` varchar(100) NOT NULL,
  `pais` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

### Comando para criar registros na tabela.
INSERT INTO `usuario` (`id`, `nome`, `password`, `email`, `sexo`, `pais`) VALUES
(05, 'José', 'Valente', 'jose@gmail.com', 'Masculino', 'Brasil'),
(06, 'Ana', 'Vitoria', 'ana@gmail.com', 'Feminino', 'Brasil'),
(08, 'Maria', 'Francisca', 'maria@gmail.com', 'Feminino', 'Brasil');

### Crétidos: https://www.youtube.com/playlist?list=PLXbKgo5jPQE_onw_8jAgEUXLP7jHgcP2-