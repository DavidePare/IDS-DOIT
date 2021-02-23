import { Progettista } from "./progettista";

export interface Team {
    id: number;
    progettistiTeam: Array<Progettista>;
    progettoID: number;
}
