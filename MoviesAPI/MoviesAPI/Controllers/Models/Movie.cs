using System.ComponentModel.DataAnnotations;

namespace MoviesAPI.Controllers.Models;

public class Movie
{
    [Key]
    [Required]
    public int Id { get; set; }

    [Required(ErrorMessage = "O título do filme é obrigatório.")]
    public string Title { get; set; }


    [Required(ErrorMessage = "O genêro do filme é obrigatório.")]
    [MaxLength(60, ErrorMessage = "O tamanho do gênero não pode exceder 60 carecteres")]
    public string Genre { get; set; }


    [Required(ErrorMessage = "A duração do filme é obrigatório.")]
    [Range(70, 600, ErrorMessage = "A duração do filme deve ser entre 70 e 600 minutos")]
    public int Duration { get; set; }
}
