package com.codinghero.interview.amazon;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

/**
 * 2015-12-13
 * 
 * @author tliu
 *
 */
public class OnlineTestSimilarMovie {

	public static class Movie {
		private final int movieId;
		private final float rating;
		private List<Movie> similarMovies; // Similarity is bidirectional

		public Movie(int movieId, float rating) {
			this.movieId = movieId;
			this.rating = rating;
			similarMovies = new ArrayList<Movie>();
		}

		public int getId() {
			return movieId;
		}

		public float getRating() {
			return rating;
		}

		public void addSimilarMovie(Movie movie) {
			similarMovies.add(movie);
			movie.similarMovies.add(this);
		}

		public List<Movie> getSimilarMovies() {
			return similarMovies;
		}
	}

	/*
	 * @param movie Current movie.
	 * 
	 * @param numTopRatedSimilarMovies the maximum number of recommended movies
	 * to return.
	 * 
	 * @return List of top rated similar movies.
	 * 
	 * Assumptions I made: TODO
	 * 
	 * Description of my approach: BFS.
	 * 
	 * Runtime complexity of my approach: O(E) + O(V). E is the number of
	 * similar relationships. V is the number of movies.
	 * 
	 * Justification of runtime complexity: TODO
	 */
	public static List<Movie> getMovieRecommendations(Movie movie, int numTopRatedSimilarMovies) {
		if (movie == null)
			return null;
		PriorityQueue<Movie> heap = new PriorityQueue<Movie>(numTopRatedSimilarMovies, new MovieComparator());
		if (movie.getSimilarMovies() != null && !movie.getSimilarMovies().isEmpty()) {
			Set<Integer> visited = new HashSet<Integer>();
			visited.add(movie.getId());
			Iterator<Movie> similarIter = movie.getSimilarMovies().iterator();
			while (similarIter.hasNext()) {
				visited.add(similarIter.next().getId());
			}
			getMovieRecommendations(movie.getSimilarMovies(), visited, heap, numTopRatedSimilarMovies);
		}

		return new LinkedList<Movie>(heap);
	}

	private static void getMovieRecommendations(List<Movie> movies, Set<Integer> visited, PriorityQueue<Movie> heap, int numTopRatedSimilarMovies) {
		if (movies == null || movies.isEmpty()) {
			return;
		}

		List<Movie> nextRoundMovies = new LinkedList<Movie>();
		Iterator<Movie> iter = movies.iterator();
		while (iter.hasNext()) {
			Movie movie = iter.next();
			tryOffer(heap, numTopRatedSimilarMovies, movie);

			if (movie.getSimilarMovies() != null) {
				Iterator<Movie> similarIter = movie.getSimilarMovies().iterator();
				while (similarIter.hasNext()) {
					Movie similarMovie = similarIter.next();
					if (!visited.contains(similarMovie.getId())) {
						nextRoundMovies.add(similarMovie);
						visited.add(similarMovie.getId());
					}
				}
			}
		}
		getMovieRecommendations(nextRoundMovies, visited, heap, numTopRatedSimilarMovies);
	}

	private static void tryOffer(PriorityQueue<Movie> heap, int capacity, Movie movie) {
		if (heap.size() < capacity) {
			heap.offer(movie);
		} else {
			if (movie.getRating() > heap.peek().getRating()) {
				heap.poll();
				heap.offer(movie);
			}
		}
	}

	private static class MovieComparator implements Comparator<Movie> {

		@Override
		public int compare(Movie m1, Movie m2) {
			if (m1.getRating() > m2.getRating()) {
				return 1;
			} else if (m1.getRating() < m2.getRating()) {
				return -1;
			} else {
				return 0;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		final Map<Integer, Movie> movieMap = new HashMap<Integer, Movie>();
		Movie rootMovie = null;
		int numTopRatedSimilarMovies = 0;

		final Scanner in = new Scanner(System.in);
		in.useLocale(new Locale("en", "US"));

		while (in.hasNextLine()) {
			final String type = in.next();

			if (type.equals("movie")) {
				final int id = in.nextInt();
				final float rating = in.nextFloat();
				movieMap.put(id, new Movie(id, rating));
			} else if (type.equals("similar")) {
				final Movie movie1 = movieMap.get(in.nextInt());
				final Movie movie2 = movieMap.get(in.nextInt());
				movie1.addSimilarMovie(movie2);
			} else if (type.equals("params")) {
				rootMovie = movieMap.get(in.nextInt());
				numTopRatedSimilarMovies = in.nextInt();
				break;
			} else {
				// ignore comments and whitespace
			}
		}

		final List<Movie> result = getMovieRecommendations(rootMovie, numTopRatedSimilarMovies);

		String output = "result";

		if (result == null) {
			output += " <null>";
		} else {
			Collections.sort(result, new Comparator() {
				@Override
				public int compare(Object m1, Object m2) {
					return ((Movie) m1).getId() - ((Movie) m2).getId();
				}
			});

			for (Movie m : result) {
				output += " ";
				output += m.getId();
			}
		}

		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		bw.write(output);
		bw.newLine();
		bw.close();
	}
}
