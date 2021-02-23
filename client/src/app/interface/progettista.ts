import { Curriculum } from "./curriculum";
import { Progetto } from "./progetto";
import { Team } from "./team";

export interface Progettista {
    id: number;
    name: string;
    surname: string;
    progettiCandidati: Array<Progetto>;
    curriculum: Curriculum;
    progettiProgettista: Array<Progetto>;
    inviti: Array<Progetto>;
    teamsProgettista: Array<Team>;
}
