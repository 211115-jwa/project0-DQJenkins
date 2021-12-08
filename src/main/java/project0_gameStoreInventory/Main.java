package project0_gameStoreInventory;

import io.javalin.Javalin;
import static io.javalin.apibuilder.ApiBuilder.*;

public class Main {

	public static void main(String[] args) {
		Javalin app = Javalin.create();

		app.start();

		app.routes(() -> {
			// localhost:8080/product
			path("/product", () -> {
				// localhost:8080/product/game
				path("/game", () -> {
					get(ctx -> {
					});
					post(ctx -> {
					});
					// localhost:8080/product/game/{id}
					path("/{id}", () -> {
						get(ctx -> {
						});
						put(ctx -> {
						});
					});
					// localhost:8080/product/game?name=
					path("?name=", () -> {
						get(ctx -> {
						});
					});
					// localhost:8080/product/game?publisher=
					path("?publisher=", () -> {
						get(ctx -> {
						});
					});
				});

				// localhost:8080/product/hardware
//				path("/hardware", () -> {
//					get(ctx -> {
//					});
//					post(ctx -> {
//					});
//					// localhost:8080/product/hardware/{id}
//					path("/{id}", () -> {
//						get(ctx -> {
//						});
//						put(ctx -> {
//						});
//					});
//					// localhost:8080/product/hardware?name=
//					path("?name=", () -> {
//						get(ctx -> {
//						});
//					});
//					// localhost:8080/product/hardware?manufacturer=
//					path("?manufacturer=", () -> {
//						get(ctx -> {
//						});
//					});
			});
		});
	}
}
