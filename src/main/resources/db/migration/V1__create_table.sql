CREATE TABLE IF NOT EXISTS cards (
    id INT AUTO_INCREMENT PRIMARY KEY,
    pokemon_name VARCHAR(255),
    additional_info VARCHAR(255),
    index VARCHAR(255),
    expansion VARCHAR(255)
);