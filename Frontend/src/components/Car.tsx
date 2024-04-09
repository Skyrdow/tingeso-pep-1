import React from 'react';
import { Car } from '../types';

interface CarProps {
    data: Car;
}

const CarElement: React.FC<CarProps> = ({ data }) => {
    return (
        <li className="flex">

            <h2>{data.brand}</h2>
            <p>{data.model}</p>
            <p>{data.patent}</p>
        </li>
    );
};

export default CarElement;