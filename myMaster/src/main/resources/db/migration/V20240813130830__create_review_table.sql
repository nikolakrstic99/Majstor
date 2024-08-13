DROP TABLE IF EXISTS review;

CREATE TABLE review
(
    id               BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    rated_user_id    BIGINT NOT NULL,
    creator_user_id  BIGINT NOT NULL,
    rating           INT NOT NULL,
    text             VARCHAR(1000),
    created_at       TIMESTAMP NOT NULL DEFAULT NOW(),

    CONSTRAINT fk_review_rated_user_id
        FOREIGN KEY (rated_user_id) REFERENCES users(id),

    CONSTRAINT fk_review_creator_user_id
        FOREIGN KEY (creator_user_id) REFERENCES users(id)
);
