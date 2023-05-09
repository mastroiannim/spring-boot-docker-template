CREATE TABLE IF NOT EXISTS bot_user (
    objectId SERIAL PRIMARY KEY,
    username TEXT NOT NULL,
    firstname TEXT,
    lastname TEXT,
    value REAL
);