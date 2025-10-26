CREATE TYPE role_type AS ENUM ('ADMIN', 'ORGANIZER', 'SPEAKER');
CREATE TYPE slot_status AS ENUM ('SIGNED', 'UNSIGNED');

CREATE TABLE events(
    id BIGSERIAL PRIMARY KEY,
    uuid UUID UNIQUE NOT NULL,
    name VARCHAR(256) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    place VARCHAR(256)
);

CREATE TABLE people(
    id BIGSERIAL PRIMARY KEY,
    uuid UUID UNIQUE NOT NULL,
    first_name VARCHAR(128) NOT NULL,
    last_name VARCHAR(128) NOT NULL,
    email VARCHAR(128) UNIQUE NOT NULL,
    telegram_id VARCHAR(128) UNIQUE
);

CREATE TABLE event_person_role(
    id BIGSERIAL PRIMARY KEY,
    uuid UUID UNIQUE NOT NULL,
    person_id BIGINT NOT NULL REFERENCES people(id) ON DELETE CASCADE,
    event_id BIGINT NOT NULL REFERENCES events(id) ON DELETE CASCADE,
    role role_type NOT NULL,
    UNIQUE (person_id, event_id, role)
);

CREATE TABLE slots(
    uuid UUID PRIMARY KEY,
    role_id BIGINT NULL REFERENCES event_person_role(id) ON DELETE SET NULL,
    interview_date TIMESTAMP NOT NULL,
    place VARCHAR(128) NOT NULL,
    topic VARCHAR(128) NOT NULL,
    status slot_status NOT NULL DEFAULT 'UNSIGNED',
    CHECK ((status = 'UNSIGNED' AND role_id IS NULL) OR (status = 'SIGNED' AND role_id IS NOT NULL))
);