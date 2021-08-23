

drop table if exists movies;
create table movies
(
    id       bigserial PRIMARY KEY,
    name     VARCHAR(255) NOT NULL,
    duration integer      NOT NULL
);

drop table if exists sessions;
create table sessions
(
    id        bigserial PRIMARY KEY,
    movie_id  bigint    NOT NULL REFERENCES movies (id),
    startDate timestamp NOT NULL,
    price     decimal   NOT NULL
);

drop table if exists sold_tickets;
create table sold_tickets
(
    id         bigserial PRIMARY KEY,
    session_id bigint NOT NULL REFERENCES sessions (id)
);

insert into movies (name, duration)
values ('Movie One', 90),
       ('Movie Two', 90),
       ('Movie Three', 120),
       ('Movie Four', 60);

insert into sessions (movie_id, startDate, price)
values (1, '2021-05-01 8:30:00', 100),
       (1, '2021-05-01 17:00:00', 200),
       (2, '2021-05-01 10:00:00', 100),
       (2, '2021-05-01 19:00:00', 200),
       (3, '2021-05-01 11:00:00', 100),
       (3, '2021-05-01 20:00:00', 200),
       (4, '2021-05-01 12:00:00', 100),
       (4, '2021-05-01 22:00:00', 200);

insert into sold_tickets (session_id)
values (1),
       (2),
       (3),
       (4);



select first_movie.movie_name     as first_movie,
       first_movie.session_start  as first_movie_session_start,
       first_movie.duration       as first_movie_duration,
       second_movie.movie_name    as second_movie,
       second_movie.session_start as second_movie_session_start,
       second_movie.duration      as second_movie_duration
from (
         select session.id as session,
                movie.name                                               as movie_name,
                session.startDate                                        as session_start,
                movie.duration                                           as duration,
                session.startDate + movie.duration * interval '1 minute' as endDate
         from cinema.movies as movie
             inner join cinema.sessions as session
         on movie.id = session.movie_id
     ) as first_movie
         inner join (
    select session.id as session,
                movie.name        as movie_name,
                session.startDate as session_start,
                movie.duration    as duration
    from cinema.movies as movie
        inner join cinema.sessions as session
    on movie.id = session.movie_id
) as second_movie
                    on
                                first_movie.session_start <= second_movie.session_start
                            and first_movie.endDate > second_movie.session_start
                            and first_movie.session != second_movie.session
order by first_movie.session_start;


select first_movie.movie_name          as first_movie_name,
       first_movie.session_start       as first_movie_session_start,
       first_movie.duration            as first_movie_duration,
       min(second_movie.session_start) as second_movie_session_start,
       min(EXTRACT(EPOCH FROM AGE(second_movie.session_start, first_movie.endDate)) /
           60)                         as duration
from (
         select sesson.id as session,
                movie.name                                              as movie_name,
                sesson.startDate                                        as session_start,
                movie.duration                                          as duration,
                sesson.startDate + movie.duration * interval '1 minute' as endDate
         from cinema.movies as movie
             inner join cinema.sessions as sesson
         on movie.id = sesson.movie_id
     ) as first_movie
         inner join (
    select session.id as session,
                movie.name        as movie_name,
                session.startDate as session_start,
                movie.duration    as duration
    from cinema.movies as movie
        inner join cinema.sessions as session
    on movie.id = session.movie_id
) as second_movie
                    on
                                first_movie.session_start < second_movie.session_start
                            and
                                first_movie.session_start::date = second_movie.session_start::date
group by first_movie_name,
    first_movie_session_start,
    first_movie_duration

having min (EXTRACT (EPOCH FROM AGE(second_movie.session_start, first_movie.endDate)) / 60) >= 30

order by min (EXTRACT (EPOCH FROM AGE(second_movie.session_start, first_movie.endDate)) / 60) desc,
    first_movie_session_start;