package com.revature.app;

import io.javalin.Javalin;
import io.javalin.http.HttpCode;

import static io.javalin.apibuilder.ApiBuilder.*;

import java.util.Set;

import org.eclipse.jetty.http.HttpStatus;

import com.revature.beans.Game;
import com.revature.services.UserService;
import com.revature.services.UserServiceImpl;

public class Main {
	private static UserService userServ = new UserServiceImpl();

	public static void main(String[] args) {
		Javalin app = Javalin.create();

		app.start();

		app.routes(() -> {
			// localhost:8080/game
			path("/game", () -> {
				get(ctx -> {
					// checking for 3 different queryParameters
					String nameSearch = ctx.queryParam("name");
					String platformSearch = ctx.queryParam("platform");
					String publisherSearch = ctx.queryParam("publisher");
					// when using .equals with a String literal, put the
					// String literal first because it prevents null pointer
					// exceptions
					if (nameSearch != null && !"".equals(nameSearch)) {
						Set<Game> gamesFound = userServ.searchGamesByName(nameSearch);
						ctx.json(gamesFound);
					} else if (platformSearch != null && !"".equals(platformSearch)) {
						Set<Game> gamesFound = userServ.searchGamesByPlatform(platformSearch);
						ctx.json(gamesFound);
					} else if (publisherSearch != null && !"".equals(publisherSearch)) {
						Set<Game> gamesFound = userServ.searchGamesByPublisher(publisherSearch);
						ctx.json(gamesFound);
					} else {
						// if they didn't use a query parameter
						Set<Game> allGames = userServ.viewAllGames();
						ctx.json(allGames);
					}

				});
				post(ctx -> {
					Game newGame = ctx.bodyAsClass(Game.class);
					if (newGame !=null) {
						userServ.addNewGame(newGame);
						ctx.status(HttpStatus.CREATED_201);
					} else {
						ctx.status(HttpStatus.BAD_REQUEST_400);
					}
				});
				// localhost:8080/game/{id}
				path("/{id}", () -> {
					get(ctx -> {
						try {
							int gameId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							Game game = userServ.getGameById(gameId);
							if (game != null)
								ctx.json(game);
							else
								ctx.status(404);
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Game ID must be a numeric value");
						}
					});
					put(ctx -> {
						try {
							int gameId = Integer.parseInt(ctx.pathParam("id")); // num format exception
							Game gameToEdit = ctx.bodyAsClass(Game.class);
							if (gameToEdit != null && gameToEdit.getId() == gameId) {
								gameToEdit = userServ.editGame(gameToEdit);
								if (gameToEdit != null)
									ctx.json(gameToEdit);
								else
									ctx.status(404);
							} else {
								// conflict: the id doesn't match the id of the game sent
								ctx.status(HttpCode.CONFLICT);
							}
						} catch (NumberFormatException e) {
							ctx.status(400);
							ctx.result("Game ID must be a numeric value");
						}
					});
				});
			});
		});
	}
}
