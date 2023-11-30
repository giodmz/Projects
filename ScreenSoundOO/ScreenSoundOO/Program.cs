Episodio ep1 = new(2, "Técnicas de Facilitação", 45);
ep1.AdicionarConvidados("Dku");
ep1.AdicionarConvidados("Celin");

Episodio ep2 = new(1, "Técnicas de Aprendizado", 63);
ep2.AdicionarConvidados("Robertin");
ep2.AdicionarConvidados("Mendigasso");
ep2.AdicionarConvidados("Nariz");

Podcast podcast = new("Podcast especial", "Gio");
podcast.AdicionarEpisodio(ep1);
podcast.AdicionarEpisodio(ep2);
podcast.ExibirDetalhes();
