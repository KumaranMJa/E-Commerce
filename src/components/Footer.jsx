// src/components/Footer.jsx

import React from 'react';

function Footer() {
  return (
    <footer className="footer mt-auto py-2 bg-light">
      <div className="container text-center">
        <span className="text-muted">
          &copy; {new Date().getFullYear()} Your Ecommerce Site. All rights reserved.
        </span>
      </div>
    </footer>
  );
}

export default Footer;