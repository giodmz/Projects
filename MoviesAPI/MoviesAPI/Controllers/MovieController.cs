using Microsoft.AspNetCore.Mvc;
using MoviesAPI.Controllers.Models;

namespace MoviesAPI.Controllers;

[ApiController]
[Route("[controller]")]

public class MovieController : ControllerBase
{
    private static List<Movie> movies = new List<Movie>();

    [HttpPost]
    public void AddMovie([FromBody]Movie movie)
    {
        if (!string.IsNullOrEmpty(movie.Title) &&
            movie.Title.Length <= 500 &&
            !string.IsNullOrEmpty(movie.Title) &&
            movie.Duration >= 70)
        {
            movies.Add(movie);
            Console.WriteLine(movie.Title);
            Console.WriteLine(movie.Duration);

        } 
        
    }

}

