import { Progettista } from "./progettista";
import { Sponsor } from "./sponsor";
import { Team } from "./team";

export interface Progetto {
        id: number;
        nMaxProgettisti: number;
        nState: string;
        amount: number;
        team: Team;
        espertoId: number;
        scadenza: Date;
        proponenteProgettoID: number;
        progettistiInvitati: Array<Progettista>;
        candidati: Array<Progettista>;
        sponsors: Array<Sponsor>;
}
