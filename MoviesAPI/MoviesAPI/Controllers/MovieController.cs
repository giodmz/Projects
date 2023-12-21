using AutoMapper;
using Microsoft.AspNetCore.Mvc;
using MoviesAPI.Controllers.Models;
using MoviesAPI.Data;
using MoviesAPI.Data.DTOs;

namespace MoviesAPI.Controllers;

[ApiController]
[Route("[controller]")]

public class MovieController : ControllerBase
{
    private MovieContext _context;
    private IMapper _mapper;

    public MovieController(MovieContext context, IMapper mapper)
    {
        _context = context;
        _mapper = mapper;
    }

    [HttpPost]
    public IActionResult AddMovie([FromBody] CreateMovieDto movieDto)
    {

        Movie movie = _mapper.Map<Movie>(movieDto);
        _context.Movies.Add(movie);
        _context.SaveChanges();
        return CreatedAtAction(nameof(RecoveryMovieById), 
            new { id = movie.Id }, 
            movie);
        
    }

    [HttpGet]
    public IEnumerable<Movie> RecoveryMovie([FromQuery]int skip = 0, [FromQuery] int take = 50)
    {
        return _context.Movies.Skip(skip).Take(take);
    }

    [HttpGet("{id}")]
    public IActionResult RecoveryMovieById(int id)
    {
       var movie = _context.Movies
            .FirstOrDefault(movie => movie.Id == id);
       if (movie == null) return NotFound();
       return Ok(movie);
    }

}

