package com.pure.awsm.resolver.movie.query;

import com.pure.awsm.domain.movie.NavigationTitle;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class NavigationTitleResolver implements GraphQLQueryResolver {

    public List<NavigationTitle> navigationTitles() {
        log.info("Retrieving All Navigation Titles ");

        List<NavigationTitle> navigation = new ArrayList<>();
        navigation.add(NavigationTitle.builder().fetch("fetchTrending").title("Trending").url("/trending/all/week?api_key=${API_KEY}&language=en-US").build());
        navigation.add(NavigationTitle.builder().fetch("fetchTopRated").title("Top Rated").url("/movie/top_rated?api_key=${API_KEY}&language=en-US").build());
        navigation.add(NavigationTitle.builder().fetch("fetchActionMovies").title("Action").url("/discover/movie?api_key=${API_KEY}&with_genres=28").build());
        navigation.add(NavigationTitle.builder().fetch("fetchComedyMovies").title("Comedy").url("/discover/movie?api_key=${API_KEY}&with_genres=35").build());
        navigation.add(NavigationTitle.builder().fetch("fetchHorrorMovies").title("Horror").url("/discover/movie?api_key=${API_KEY}&with_genres=27").build());
        navigation.add(NavigationTitle.builder().fetch("fetchRomanceMovies").title("Romance").url("/discover/movie?api_key=${API_KEY}&with_genres=10749").build());
        navigation.add(NavigationTitle.builder().fetch("fetchMystery").title("Mystery").url("/discover/movie?api_key=${API_KEY}&with_genres=9648").build());
        navigation.add(NavigationTitle.builder().fetch("fetchSicFic").title("Sci-Fic").url("/discover/movie?api_key=${API_KEY}&with_genres=878").build());
        navigation.add(NavigationTitle.builder().fetch("fetchWestern").title("Western").url("/discover/movie?api_key=${API_KEY}&with_genres=37").build());
        navigation.add(NavigationTitle.builder().fetch("fetchAnimation").title("Animation").url("/discover/movie?api_key=${API_KEY}&with_genres=16").build());
        navigation.add(NavigationTitle.builder().fetch("fetchTV").title("TV Movie").url("/discover/movie?api_key=${API_KEY}&with_genres=10770").build());

        return navigation;
    }
}
