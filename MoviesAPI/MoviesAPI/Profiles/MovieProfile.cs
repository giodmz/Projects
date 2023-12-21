using AutoMapper;
using MoviesAPI.Controllers.Models;
using MoviesAPI.Data.DTOs;

namespace MoviesAPI.Profiles;

public class MovieProfile : Profile
{
    public MovieProfile()
    {
        CreateMap<CreateMovieDto, Movie>();
    }
}
