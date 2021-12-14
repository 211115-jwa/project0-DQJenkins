package com.revature.app;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {

	public static void main(String[] args) {
		Javalin app = Javalin.create();

		app.start();

		app.routes(() -> {
			// localhost:8080/game
			path("/game", () -> {
				get(ctx -> {
				});
				post(ctx -> {
				});
				// localhost:8080/game/{id}
				path("/{id}", () -> {
					get(ctx -> {
					});
					put(ctx -> {
					});
				});
				// localhost:8080/game?name=
				path("?name=", () -> {
					get(ctx -> {
					});
				});
				// localhost:8080/game?publisher=
				path("?publisher=", () -> {
					get(ctx -> {
					});
				});
			});
		});
	}
}
