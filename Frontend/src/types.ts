export enum MotorType {
    Gasolina, Diesel, Hibrido, Electrico
}
export enum CarType {
    Sedan, Hatchback, SUV, Pickup, Furgoneta
}

export enum ReparationType {
    Frenos, Refrigeracion, Motor, Transmision, Electrico, Escape, Neumaticos, Suspension, Calefaccion, Combustible, Parabrisas
}

export type Car = {
    patent: string;
    brand: string;
    model: string;
    fabDate: Date;
    mileage: number;
    seatCount: number;
    motorType: MotorType|undefined;	
    carType: CarType|undefined;
};

export type ReparationTypeEntity = {
    reparationType: ReparationType;
};

export type Reparation = {
    patent: string;
    addmissionDate: Date;
    reparationTypes: ReparationTypeEntity[];
    repairExitDate: Date;
    retrievalDate: Date;
};