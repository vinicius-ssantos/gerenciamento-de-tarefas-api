DO $$
BEGIN
    IF NOT EXISTS (SELECT FROM pg_database WHERE datname = 'gerenciamento-de-tarefas') THEN
      PERFORM dblink_exec('dbname=' || current_database(), 'CREATE DATABASE gerenciamento-de-tarefas');
END IF;
END
    $$;


