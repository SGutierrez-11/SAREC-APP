'use client';

import '../styles/globals.css';
import React from 'react';

interface Props {
    onSelect: (option: string) => void;
}

export const SideBar: React.FC<Props> = ({ onSelect }) => {

    const handleClick = (event: React.MouseEvent<HTMLAnchorElement>, option: string) => {
        event.preventDefault();
        onSelect(option);
    };

    return (
        <div className="dashBoardContainer flex flex-col items-center top-5 w-full justify-between">
            <div>
                <h1 className='font-bold text-2xl pb-20 pt-5'>DashBoard</h1>
                <div id='sideBarOption' className='dashBoardContainer'>
                    <ul>
                        <li><a className='hover:cursor-pointer' onClick={(e) => handleClick(e, 'payments')}>Pagos</a></li>
                        <li><a className='hover:cursor-pointer' onClick={(e) => handleClick(e, 'history')}>Historial</a></li>
                    </ul>
                </div>
            </div>
            <div className="bottomFlex mb-4">
                <h1>Log out</h1>
            </div>
        </div>
    );
};
