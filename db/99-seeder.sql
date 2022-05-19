USE spring_blog_db;

# ==================  Pet Seeder

# (1) pet_details                   [PK]                                   <-- child first, then parent
# NONE HERE # private long id;

# 1. private boolean isSterile;
# 2. private String personalityDescription;
# 3. private int weightInOunces;
INSERT INTO pet_details (is_sterile, personality_description, weight_in_ounces)
VALUES (TRUE, 'Very happy', 45.23),
       (FALSE, 'Sad', 15.23),
       (TRUE, 'Aggressive', 5.23),
       (FALSE, 'Hyper', 95.23);


# (2) pets
# NONE HERE # private long id;      [PK]

# 1. private int age;
# 2. private String name;
# 3. private String type;
# 4. pet_details_id                 [FK]
INSERT INTO pets (age, name, type, pet_details_id)
VALUES (3, 'Sparky', 'Dog', null),
       (10, 'Pickles', 'Cat', 1),
       (4, 'Sampson', 'Fish', 2),
       (5, 'Chili', 'Alligator', 3),
       (2, 'Spot', 'Snake', 4);

# (3) chew_toys
# NONE HERE # private long id;      [PK0

# 1. private String name;
# 2. private String brand;
# 3. private boolean isDestroyed;
# 4 private Pet pet_id              [FK]
INSERT INTO chew_toys (name, brand, is_destroyed, pet_id)
VALUES ('Little Bone', 'Greater Toy Inc', false, 2),
       ('Good String Inc.', 'bundle of yarn', TRUE,  2),
       ('Toys Arf Us.', 'rope', FALSE, 2),
       ('Not For Tennis', 'green chew ball', FALSE,  3);

# ==================  Post Details Seeder

# (1) post_details
# NONE HERE #private long id;       [PK]

# 1. private boolean isAwesome;
# 2. private String historyOfPost;
# 3. private String topicDescription;
INSERT INTO post_details (is_awesome, history_of_post, topic_description)
VALUES (TRUE, '2022 05 02', 'Funny'),
       (FALSE, '2021 04 01', 'SQL'),
       (TRUE, '2021 03 05', 'HTML'),
       (FALSE, '2020 08 14', 'Java');


# (2) post
# NONE HERE # private long id;      [PK]

# 1. private String title;
# 2. private String body;
# 3. post_details_id                [FK]    1-to-1
# 3. user_id                        [FK]    M-to-1
INSERT INTO posts (title, body, post_details_id, user_id)
VALUES ( 'It takes Three to Pair Program',
        'Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet, consectetur, adipisci[ng] velit, sed quia non numquam [do] eius modi tempora inci[di]dunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur?',
        1,
        1),
       ( 'Have You Seen my Programmer?',
         'Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet, consectetur, adipisci[ng] velit, sed quia non numquam [do] eius modi tempora inci[di]dunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur?',
        2,
        1),
       ( 'Will You Wright on my Wonder Billboard',
         'Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet, consectetur, adipisci[ng] velit, sed quia non numquam [do] eius modi tempora inci[di]dunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur?',
        3,
        2),
       ( 'Errors Everywhere',
         'Nemo enim ipsam voluptatem, quia voluptas sit, aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos, qui ratione voluptatem sequi nesciunt, neque porro quisquam est, qui dolorem ipsum, quia dolor sit amet, consectetur, adipisci[ng] velit, sed quia non numquam [do] eius modi tempora inci[di]dunt, ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit, qui in ea voluptate velit esse, quam nihil molestiae consequatur, vel illum, qui dolorem eum fugiat, quo voluptas nulla pariatur?',
        4,
        3)
         ;

# (3) post_images
# NONE HERE #private long id;       [PK]

# 1. private String image_title;
# 2. private String url;
# 3. private long post_id;
INSERT INTO post_images (image_title, url, post_id)
VALUES ('kitten basket', 'https://placekitten.com/408/287', 1),
       ('ugly', 'https://placekitten.com/96/139', 2),
       ('nosey', 'https://placekitten.com/200/287', 3),
       ('white', 'https://placekitten.com/200/138', 4),
       ('divine', 'https://placekitten.com/96/140', 2),
       ('eyes', 'https://placekitten.com/200/286', 1);

# (4) users
# NONE HERE #private long id;       [PK]

# 1. private String username;
# 2. private String email;
# 3. private String password;
# 4. private String bio;
# 5. private List<Post> posts;      [FK]

INSERT INTO users (username, email, password, bio)
VALUES ('Smash', 'smash@mail.com', '1234', 'Breaks stuff...'),
       ('Calvin', 'calvin@mail.com', '1234', 'Loud but lovable...'),
       ('Mocha', 'mocha@mail.com', '1234', 'Cute and cuddly...');
