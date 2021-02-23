import { Progettista } from "./progettista";
import { Progetto } from "./progetto";

export interface Proponenteprogetto extends Progettista {
    progettiGestiti: Array<Progetto>;
}
