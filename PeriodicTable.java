/**
 * PeriodicTable class - stores and manages all elements
 * Demonstrates data structure and search capabilities
 */
public class PeriodicTable {
    private Element[] elements;
    private int size;
    private static final int MAX_ELEMENTS = 118;

    public PeriodicTable() {
        this.elements = new Element[MAX_ELEMENTS];
        this.size = 0;
        initializeElements();
    }

    public void addElement(Element element) {
        if (size < MAX_ELEMENTS) {
            elements[size++] = element;
        }
    }

    public Element[] getAllElements() {
        Element[] result = new Element[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }

    public Element[] searchBySymbol(String symbol) {
        java.util.ArrayList<Element> results = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (elements[i].getSymbol().equalsIgnoreCase(symbol)) {
                results.add(elements[i]);
            }
        }
        return results.toArray(new Element[0]);
    }

    public Element[] searchByName(String name) {
        java.util.ArrayList<Element> results = new java.util.ArrayList<>();
        String lowerName = name.toLowerCase();
        for (int i = 0; i < size; i++) {
            if (elements[i].getName().toLowerCase().contains(lowerName)) {
                results.add(elements[i]);
            }
        }
        return results.toArray(new Element[0]);
    }

    public Element[] searchByAtomicNumber(int atomicNumber) {
        java.util.ArrayList<Element> results = new java.util.ArrayList<>();
        for (int i = 0; i < size; i++) {
            if (elements[i].getAtomicNumber() == atomicNumber) {
                results.add(elements[i]);
            }
        }
        return results.toArray(new Element[0]);
    }

    public Element[] searchByCategory(String category) {
        java.util.ArrayList<Element> results = new java.util.ArrayList<>();
        String lowerCategory = category.toLowerCase();
        for (int i = 0; i < size; i++) {
            if (elements[i].getCategory().toLowerCase().contains(lowerCategory)) {
                results.add(elements[i]);
            }
        }
        return results.toArray(new Element[0]);
    }

    public int getSize() {
        return size;
    }

    private void initializeElements() {
        // Period 1
        addElement(new Element("H", "Hydrogen", 1, 1.008, "1", "1", "Nonmetal",
                new String[]{"Rocket fuel", "Fuel cells", "Hydrogenation of oils"},
                "The lightest and most abundant element in the universe."));
        addElement(new Element("He", "Helium", 2, 4.003, "18", "1", "Noble Gas",
                new String[]{"Balloons", "Cooling MRI machines", "Welding"},
                "The second lightest element, used in balloons."));
        
        // Period 2
        addElement(new Element("Li", "Lithium", 3, 6.941, "1", "2", "Alkali Metal",
                new String[]{"Batteries", "Psychiatric medication", "Alloys"},
                "The lightest metal, essential for rechargeable batteries."));
        addElement(new Element("Be", "Beryllium", 4, 9.012, "2", "2", "Alkaline Earth Metal",
                new String[]{"Aerospace", "X-ray windows", "Nuclear applications"},
                "Lightweight metal used in aerospace applications."));
        addElement(new Element("B", "Boron", 5, 10.811, "13", "2", "Metalloid",
                new String[]{"Glass", "Fiberglass", "Nuclear control rods", "Detergents"},
                "Hard metalloid used in glass and nuclear applications."));
        addElement(new Element("C", "Carbon", 6, 12.011, "14", "2", "Nonmetal",
                new String[]{"Steel production", "Diamonds", "Graphite", "Organic compounds"},
                "The basis of all organic life and many materials."));
        addElement(new Element("N", "Nitrogen", 7, 14.007, "15", "2", "Nonmetal",
                new String[]{"Fertilizers", "Food packaging", "Cooling", "Ammonia production"},
                "Makes up 78% of Earth's atmosphere."));
        addElement(new Element("O", "Oxygen", 8, 15.999, "16", "2", "Nonmetal",
                new String[]{"Respiration", "Steel production", "Welding", "Medical treatment"},
                "Essential for life, makes up 21% of atmosphere."));
        addElement(new Element("F", "Fluorine", 9, 18.998, "17", "2", "Halogen",
                new String[]{"Toothpaste", "Refrigeration", "Teflon", "Pharmaceuticals"},
                "The most reactive element."));
        addElement(new Element("Ne", "Neon", 10, 20.180, "18", "2", "Noble Gas",
                new String[]{"Neon signs", "Cryogenic refrigeration", "Lasers"},
                "Used in colorful neon signs."));
        
        // Period 3
        addElement(new Element("Na", "Sodium", 11, 22.990, "1", "3", "Alkali Metal",
                new String[]{"Table salt", "Soap", "Street lighting", "Food preservation"},
                "Highly reactive alkali metal, part of table salt."));
        addElement(new Element("Mg", "Magnesium", 12, 24.305, "2", "3", "Alkaline Earth Metal",
                new String[]{"Alloys", "Fireworks", "Medications", "Aircraft construction"},
                "Lightweight metal used in alloys and fireworks."));
        addElement(new Element("Al", "Aluminium", 13, 26.982, "13", "3", "Post-Transition Metal",
                new String[]{"Beverage cans", "Aircraft", "Construction", "Packaging"},
                "Lightweight, corrosion-resistant metal."));
        addElement(new Element("Si", "Silicon", 14, 28.085, "14", "3", "Metalloid",
                new String[]{"Computer chips", "Solar panels", "Glass", "Semiconductors"},
                "Essential for electronics and solar technology."));
        addElement(new Element("P", "Phosphorus", 15, 30.974, "15", "3", "Nonmetal",
                new String[]{"Fertilizers", "Matches", "Detergents", "Fireworks"},
                "Important for DNA, RNA, and ATP in living organisms."));
        addElement(new Element("S", "Sulfur", 16, 32.065, "16", "3", "Nonmetal",
                new String[]{"Gunpowder", "Fertilizers", "Rubber vulcanization", "Batteries"},
                "Yellow solid used in many industrial processes."));
        addElement(new Element("Cl", "Chlorine", 17, 35.453, "17", "3", "Halogen",
                new String[]{"Water treatment", "PVC", "Bleach", "Swimming pools"},
                "Common disinfectant for water purification."));
        addElement(new Element("Ar", "Argon", 18, 39.948, "18", "3", "Noble Gas",
                new String[]{"Lighting", "Welding", "Window insulation", "Food packaging"},
                "Inert gas used in lighting and welding."));
        
        // Period 4
        addElement(new Element("K", "Potassium", 19, 39.098, "1", "4", "Alkali Metal",
                new String[]{"Fertilizers", "Soap", "Food preservation", "Medicine"},
                "Essential nutrient for plants and animals."));
        addElement(new Element("Ca", "Calcium", 20, 40.078, "2", "4", "Alkaline Earth Metal",
                new String[]{"Bones and teeth", "Cement", "Milk", "Supplements"},
                "Essential for strong bones and teeth."));
        addElement(new Element("Sc", "Scandium", 21, 44.956, "3", "4", "Transition Metal",
                new String[]{"Aerospace alloys", "Baseball bats", "High-intensity lights"},
                "Lightweight transition metal used in alloys."));
        addElement(new Element("Ti", "Titanium", 22, 47.867, "4", "4", "Transition Metal",
                new String[]{"Aircraft", "Medical implants", "Jewelry", "Titanium dioxide"},
                "Strong, lightweight, corrosion-resistant metal."));
        addElement(new Element("V", "Vanadium", 23, 50.942, "5", "4", "Transition Metal",
                new String[]{"Steel alloys", "Catalysts", "Vanadium batteries"},
                "Used to strengthen steel and in batteries."));
        addElement(new Element("Cr", "Chromium", 24, 51.996, "6", "4", "Transition Metal",
                new String[]{"Stainless steel", "Chrome plating", "Pigments", "Alloys"},
                "Essential for stainless steel production."));
        addElement(new Element("Mn", "Manganese", 25, 54.938, "7", "4", "Transition Metal",
                new String[]{"Steel production", "Batteries", "Fertilizers", "Pigments"},
                "Essential for steel production and batteries."));
        addElement(new Element("Fe", "Iron", 26, 55.845, "8", "4", "Transition Metal",
                new String[]{"Steel production", "Blood (hemoglobin)", "Magnets", "Construction"},
                "Most used metal, essential in steel production."));
        addElement(new Element("Co", "Cobalt", 27, 58.933, "9", "4", "Transition Metal",
                new String[]{"Batteries", "Magnets", "Pigments", "Medical isotopes"},
                "Essential for lithium-ion batteries and magnets."));
        addElement(new Element("Ni", "Nickel", 28, 58.693, "10", "4", "Transition Metal",
                new String[]{"Stainless steel", "Batteries", "Coins", "Catalysts"},
                "Used in stainless steel and batteries."));
        addElement(new Element("Cu", "Copper", 29, 63.546, "11", "4", "Transition Metal",
                new String[]{"Electrical wiring", "Coins", "Plumbing", "Electronics"},
                "Excellent conductor of electricity."));
        addElement(new Element("Zn", "Zinc", 30, 65.380, "12", "4", "Transition Metal",
                new String[]{"Galvanizing steel", "Batteries", "Sunscreen", "Supplements"},
                "Protects steel from rusting through galvanization."));
        addElement(new Element("Ga", "Gallium", 31, 69.723, "13", "4", "Post-Transition Metal",
                new String[]{"Semiconductors", "LEDs", "Solar cells", "Thermometers"},
                "Melts in your hand, used in semiconductors."));
        addElement(new Element("Ge", "Germanium", 32, 72.630, "14", "4", "Metalloid",
                new String[]{"Semiconductors", "Fiber optics", "Infrared optics"},
                "Important semiconductor material."));
        addElement(new Element("As", "Arsenic", 33, 74.922, "15", "4", "Metalloid",
                new String[]{"Semiconductors", "Pesticides (historical)", "Alloys"},
                "Toxic metalloid, historically used in pesticides."));
        addElement(new Element("Se", "Selenium", 34, 78.971, "16", "4", "Nonmetal",
                new String[]{"Photocopiers", "Glass", "Supplements", "Solar cells"},
                "Essential trace element for living organisms."));
        addElement(new Element("Br", "Bromine", 35, 79.904, "17", "4", "Halogen",
                new String[]{"Flame retardants", "Pharmaceuticals", "Photography", "Water treatment"},
                "Liquid halogen used in flame retardants."));
        addElement(new Element("Kr", "Krypton", 36, 83.798, "18", "4", "Noble Gas",
                new String[]{"Lighting", "Lasers", "Photography", "Energy-efficient windows"},
                "Used in specialized lighting and lasers."));
        
        // Period 5
        addElement(new Element("Rb", "Rubidium", 37, 85.468, "1", "5", "Alkali Metal",
                new String[]{"Atomic clocks", "Vacuum tubes", "Specialized glass"},
                "Used in atomic clocks and research."));
        addElement(new Element("Sr", "Strontium", 38, 87.620, "2", "5", "Alkaline Earth Metal",
                new String[]{"Fireworks", "Medical imaging", "Ferrite magnets"},
                "Used in red fireworks and medical imaging."));
        addElement(new Element("Y", "Yttrium", 39, 88.906, "3", "5", "Transition Metal",
                new String[]{"LEDs", "Superconductors", "Lasers", "Camera lenses"},
                "Used in LEDs and superconductors."));
        addElement(new Element("Zr", "Zirconium", 40, 91.224, "4", "5", "Transition Metal",
                new String[]{"Nuclear reactors", "Surgical instruments", "Jewelry"},
                "Corrosion-resistant, used in nuclear reactors."));
        addElement(new Element("Nb", "Niobium", 41, 92.906, "5", "5", "Transition Metal",
                new String[]{"Superconducting magnets", "Steel alloys", "MRI scanners"},
                "Used in superconducting magnets and MRI scanners."));
        addElement(new Element("Mo", "Molybdenum", 42, 95.950, "6", "5", "Transition Metal",
                new String[]{"Steel alloys", "Lubricants", "Catalysts", "Electronics"},
                "Strengthens steel and used as lubricant."));
        addElement(new Element("Tc", "Technetium", 43, 98.000, "7", "5", "Transition Metal",
                new String[]{"Medical imaging", "Nuclear medicine", "Research"},
                "First artificially produced element, used in medicine."));
        addElement(new Element("Ru", "Ruthenium", 44, 101.070, "8", "5", "Transition Metal",
                new String[]{"Electronics", "Catalysts", "Jewelry", "Hard disk drives"},
                "Hard metal used in electronics and catalysts."));
        addElement(new Element("Rh", "Rhodium", 45, 102.906, "9", "5", "Transition Metal",
                new String[]{"Catalytic converters", "Jewelry", "Electrical contacts"},
                "Rarest precious metal, used in catalytic converters."));
        addElement(new Element("Pd", "Palladium", 46, 106.420, "10", "5", "Transition Metal",
                new String[]{"Catalytic converters", "Jewelry", "Electronics", "Hydrogen storage"},
                "Used in catalytic converters and jewelry."));
        addElement(new Element("Ag", "Silver", 47, 107.868, "11", "5", "Transition Metal",
                new String[]{"Jewelry", "Photography", "Electronics", "Coins"},
                "Best conductor of electricity and heat."));
        addElement(new Element("Cd", "Cadmium", 48, 112.414, "12", "5", "Transition Metal",
                new String[]{"Batteries", "Pigments", "Nuclear reactors", "Electroplating"},
                "Used in batteries and nuclear reactors."));
        addElement(new Element("In", "Indium", 49, 114.818, "13", "5", "Post-Transition Metal",
                new String[]{"Touch screens", "Semiconductors", "Solar cells", "Bearings"},
                "Essential for touch screen technology."));
        addElement(new Element("Sn", "Tin", 50, 118.710, "14", "5", "Post-Transition Metal",
                new String[]{"Canned food", "Solder", "Bronze", "Glass"},
                "Used in cans and solder."));
        addElement(new Element("Sb", "Antimony", 51, 121.760, "15", "5", "Metalloid",
                new String[]{"Flame retardants", "Batteries", "Ceramics", "Alloys"},
                "Used in flame retardants and batteries."));
        addElement(new Element("Te", "Tellurium", 52, 127.600, "16", "5", "Metalloid",
                new String[]{"Solar cells", "Alloys", "Semiconductors", "Glass"},
                "Used in solar cells and semiconductors."));
        addElement(new Element("I", "Iodine", 53, 126.904, "17", "5", "Halogen",
                new String[]{"Medical disinfectant", "Nutrition", "Photography", "Dyes"},
                "Essential nutrient, used in medicine."));
        addElement(new Element("Xe", "Xenon", 54, 131.293, "18", "5", "Noble Gas",
                new String[]{"Lighting", "Medical imaging", "Anesthesia", "Spacecraft propulsion"},
                "Used in specialized lighting and medical imaging."));
        
        // Period 6
        addElement(new Element("Cs", "Cesium", 55, 132.905, "1", "6", "Alkali Metal",
                new String[]{"Atomic clocks", "Drilling fluids", "Photocells"},
                "Most reactive metal, used in atomic clocks."));
        addElement(new Element("Ba", "Barium", 56, 137.327, "2", "6", "Alkaline Earth Metal",
                new String[]{"Medical imaging", "Fireworks", "Glass", "Drilling fluids"},
                "Used in medical imaging and fireworks."));
        
        // Lanthanides (Period 6, Group 3)
        addElement(new Element("La", "Lanthanum", 57, 138.905, "-", "6", "Lanthanide",
                new String[]{"Camera lenses", "Batteries", "Catalysts", "Lighting"},
                "First lanthanide, used in camera lenses."));
        addElement(new Element("Ce", "Cerium", 58, 140.116, "-", "6", "Lanthanide",
                new String[]{"Catalytic converters", "Polishing", "Flints", "Glass"},
                "Most abundant lanthanide, used in catalytic converters."));
        addElement(new Element("Pr", "Praseodymium", 59, 140.908, "-", "6", "Lanthanide",
                new String[]{"Magnets", "Lasers", "Glass coloring", "Welding goggles"},
                "Used in powerful magnets and lasers."));
        addElement(new Element("Nd", "Neodymium", 60, 144.242, "-", "6", "Lanthanide",
                new String[]{"Powerful magnets", "Lasers", "Headphones", "Motors"},
                "Used in powerful neodymium magnets."));
        addElement(new Element("Pm", "Promethium", 61, 145.000, "-", "6", "Lanthanide",
                new String[]{"Nuclear batteries", "Research", "Atomic batteries"},
                "Radioactive element used in nuclear batteries."));
        addElement(new Element("Sm", "Samarium", 62, 150.360, "-", "6", "Lanthanide",
                new String[]{"Magnets", "Nuclear reactors", "Headphones"},
                "Used in permanent magnets and nuclear reactors."));
        addElement(new Element("Eu", "Europium", 63, 151.964, "-", "6", "Lanthanide",
                new String[]{"Euro notes", "Phosphors", "Lasers", "Nuclear reactors"},
                "Used in Euro banknote security features."));
        addElement(new Element("Gd", "Gadolinium", 64, 157.250, "-", "6", "Lanthanide",
                new String[]{"MRI contrast", "Nuclear reactors", "Magnets", "Data storage"},
                "Used in MRI contrast agents."));
        addElement(new Element("Tb", "Terbium", 65, 158.925, "-", "6", "Lanthanide",
                new String[]{"Solid-state devices", "Lasers", "Color TV tubes", "Fuel cells"},
                "Used in solid-state devices and lasers."));
        addElement(new Element("Dy", "Dysprosium", 66, 162.500, "-", "6", "Lanthanide",
                new String[]{"Magnets", "Lasers", "Data storage", "Nuclear reactors"},
                "Used in high-performance magnets."));
        addElement(new Element("Ho", "Holmium", 67, 164.930, "-", "6", "Lanthanide",
                new String[]{"Magnets", "Lasers", "Nuclear control rods"},
                "Has highest magnetic permeability of any element."));
        addElement(new Element("Er", "Erbium", 68, 167.259, "-", "6", "Lanthanide",
                new String[]{"Fiber optics", "Lasers", "Nuclear applications", "Photography"},
                "Used in fiber optic communication."));
        addElement(new Element("Tm", "Thulium", 69, 168.934, "-", "6", "Lanthanide",
                new String[]{"X-ray machines", "Lasers", "Nuclear applications"},
                "Rare lanthanide used in X-ray machines."));
        addElement(new Element("Yb", "Ytterbium", 70, 173.045, "-", "6", "Lanthanide",
                new String[]{"Atomic clocks", "Lasers", "X-ray machines", "Steel"},
                "Used in atomic clocks and lasers."));
        addElement(new Element("Lu", "Lutetium", 71, 174.967, "-", "6", "Lanthanide",
                new String[]{"PET scans", "Cancer treatment", "Catalysts"},
                "Last lanthanide, used in medical imaging."));
        
        // Continuation of Period 6
        addElement(new Element("Hf", "Hafnium", 72, 178.490, "4", "6", "Transition Metal",
                new String[]{"Nuclear control rods", "Superalloys", "Plasma cutting"},
                "Used in nuclear reactor control rods."));
        addElement(new Element("Ta", "Tantalum", 73, 180.948, "5", "6", "Transition Metal",
                new String[]{"Electronics", "Surgical implants", "Capacitors", "Alloys"},
                "Biocompatible metal used in implants."));
        addElement(new Element("W", "Tungsten", 74, 183.840, "6", "6", "Transition Metal",
                new String[]{"Light bulbs", "Drill bits", "Radiation shielding", "Alloys"},
                "Highest melting point of all elements."));
        addElement(new Element("Re", "Rhenium", 75, 186.207, "7", "6", "Transition Metal",
                new String[]{"Superalloys", "Catalysts", "Jewelry", "Aerospace"},
                "Third highest melting point, used in superalloys."));
        addElement(new Element("Os", "Osmium", 76, 190.230, "8", "6", "Transition Metal",
                new String[]{"Pen tips", "Electrical contacts", "Fountain pens"},
                "Densest element, used in pen tips."));
        addElement(new Element("Ir", "Iridium", 77, 192.217, "9", "6", "Transition Metal",
                new String[]{"Spark plugs", "Crucibles", "Jewelry", "Pen nibs"},
                "Second densest element, very corrosion-resistant."));
        addElement(new Element("Pt", "Platinum", 78, 195.084, "10", "6", "Transition Metal",
                new String[]{"Catalytic converters", "Jewelry", "Investment", "Chemotherapy"},
                "Precious metal used in catalytic converters."));
        addElement(new Element("Au", "Gold", 79, 196.967, "11", "6", "Transition Metal",
                new String[]{"Jewelry", "Electronics", "Investment", "Dentistry"},
                "Precious metal valued for its beauty and conductivity."));
        addElement(new Element("Hg", "Mercury", 80, 200.592, "12", "6", "Transition Metal",
                new String[]{"Thermometers", "Fluorescent lamps", "Dental fillings", "Batteries"},
                "Liquid metal at room temperature."));
        addElement(new Element("Tl", "Thallium", 81, 204.380, "13", "6", "Post-Transition Metal",
                new String[]{"Rat poison", "Electronics", "Medical imaging", "Optics"},
                "Highly toxic element, limited modern uses."));
        addElement(new Element("Pb", "Lead", 82, 207.200, "14", "6", "Post-Transition Metal",
                new String[]{"Batteries", "Shielding radiation", "Pipes (historical)", "Solder"},
                "Dense metal, historically used in many applications."));
        addElement(new Element("Bi", "Bismuth", 83, 208.980, "15", "6", "Post-Transition Metal",
                new String[]{"Pepto-Bismol", "Alloys", "Cosmetics", "Nuclear applications"},
                "Used in medicine and low-melting alloys."));
        addElement(new Element("Po", "Polonium", 84, 209.000, "16", "6", "Metalloid",
                new String[]{"Nuclear batteries", "Antistatic devices", "Research"},
                "Radioactive element discovered by Marie Curie."));
        addElement(new Element("At", "Astatine", 85, 210.000, "17", "6", "Halogen",
                new String[]{"Cancer treatment", "Research", "Radiopharmaceuticals"},
                "Rarest naturally occurring element."));
        addElement(new Element("Rn", "Radon", 86, 222.000, "18", "6", "Noble Gas",
                new String[]{"Cancer treatment", "Radiation therapy", "Research"},
                "Radioactive noble gas, health hazard in homes."));
        
        // Period 7
        addElement(new Element("Fr", "Francium", 87, 223.000, "1", "7", "Alkali Metal",
                new String[]{"Research", "Theoretical applications"},
                "Second most reactive metal, extremely rare."));
        addElement(new Element("Ra", "Radium", 88, 226.000, "2", "7", "Alkaline Earth Metal",
                new String[]{"Medical treatments (historical)", "Research", "Luminous paints"},
                "Radioactive element discovered by Marie Curie."));
        
        // Actinides (Period 7, Group 3)
        addElement(new Element("Ac", "Actinium", 89, 227.000, "-", "7", "Actinide",
                new String[]{"Cancer treatment", "Neutron sources", "Research"},
                "First actinide, used in cancer treatment."));
        addElement(new Element("Th", "Thorium", 90, 232.038, "-", "7", "Actinide",
                new String[]{"Nuclear fuel", "Gas mantles", "Welding electrodes"},
                "Radioactive element used in nuclear applications."));
        addElement(new Element("Pa", "Protactinium", 91, 231.036, "-", "7", "Actinide",
                new String[]{"Research", "Nuclear applications"},
                "Extremely rare radioactive element."));
        addElement(new Element("U", "Uranium", 92, 238.029, "-", "7", "Actinide",
                new String[]{"Nuclear power", "Nuclear weapons", "Dating geological samples"},
                "Heavy radioactive element used in nuclear reactors."));
        addElement(new Element("Np", "Neptunium", 93, 237.000, "-", "7", "Actinide",
                new String[]{"Nuclear weapons", "Research", "Nuclear fuel"},
                "First transuranic element, used in nuclear applications."));
        addElement(new Element("Pu", "Plutonium", 94, 244.000, "-", "7", "Actinide",
                new String[]{"Nuclear weapons", "Nuclear reactors", "Spacecraft power"},
                "Used in nuclear weapons and reactors."));
        addElement(new Element("Am", "Americium", 95, 243.000, "-", "7", "Actinide",
                new String[]{"Smoke detectors", "Industrial gauges", "Research"},
                "Used in household smoke detectors."));
        addElement(new Element("Cm", "Curium", 96, 247.000, "-", "7", "Actinide",
                new String[]{"Space missions", "Research", "Nuclear applications"},
                "Named after Marie and Pierre Curie."));
        addElement(new Element("Bk", "Berkelium", 97, 247.000, "-", "7", "Actinide",
                new String[]{"Research", "Nuclear research", "Element synthesis"},
                "Named after Berkeley, California."));
        addElement(new Element("Cf", "Californium", 98, 251.000, "-", "7", "Actinide",
                new String[]{"Neutron sources", "Cancer treatment", "Research"},
                "Named after California, used as neutron source."));
        addElement(new Element("Es", "Einsteinium", 99, 252.000, "-", "7", "Actinide",
                new String[]{"Research", "Element synthesis"},
                "Named after Albert Einstein."));
        addElement(new Element("Fm", "Fermium", 100, 257.000, "-", "7", "Actinide",
                new String[]{"Research", "Element synthesis"},
                "Named after Enrico Fermi."));
        addElement(new Element("Md", "Mendelevium", 101, 258.000, "-", "7", "Actinide",
                new String[]{"Research", "Element synthesis"},
                "Named after Dmitri Mendeleev, creator of periodic table."));
        addElement(new Element("No", "Nobelium", 102, 259.000, "-", "7", "Actinide",
                new String[]{"Research", "Element synthesis"},
                "Named after Alfred Nobel."));
        addElement(new Element("Lr", "Lawrencium", 103, 266.000, "-", "7", "Actinide",
                new String[]{"Research", "Element synthesis"},
                "Named after Ernest Lawrence."));
        
        // Continuation of Period 7 (Transactinides)
        addElement(new Element("Rf", "Rutherfordium", 104, 267.000, "4", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Ernest Rutherford."));
        addElement(new Element("Db", "Dubnium", 105, 268.000, "5", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Dubna, Russia."));
        addElement(new Element("Sg", "Seaborgium", 106, 269.000, "6", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Glenn T. Seaborg."));
        addElement(new Element("Bh", "Bohrium", 107, 270.000, "7", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Niels Bohr."));
        addElement(new Element("Hs", "Hassium", 108, 269.000, "8", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Hesse, Germany."));
        addElement(new Element("Mt", "Meitnerium", 109, 278.000, "9", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Lise Meitner."));
        addElement(new Element("Ds", "Darmstadtium", 110, 281.000, "10", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Darmstadt, Germany."));
        addElement(new Element("Rg", "Roentgenium", 111, 282.000, "11", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Wilhelm Conrad Röntgen."));
        addElement(new Element("Cn", "Copernicium", 112, 285.000, "12", "7", "Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Nicolaus Copernicus."));
        addElement(new Element("Nh", "Nihonium", 113, 286.000, "13", "7", "Post-Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Japan (Nihon)."));
        addElement(new Element("Fl", "Flerovium", 114, 289.000, "14", "7", "Post-Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Flerov Laboratory of Nuclear Reactions."));
        addElement(new Element("Mc", "Moscovium", 115, 290.000, "15", "7", "Post-Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Moscow Oblast, Russia."));
        addElement(new Element("Lv", "Livermorium", 116, 293.000, "16", "7", "Post-Transition Metal",
                new String[]{"Research", "Nuclear research"},
                "Named after Lawrence Livermore National Laboratory."));
        addElement(new Element("Ts", "Tennessine", 117, 294.000, "17", "7", "Halogen",
                new String[]{"Research", "Nuclear research"},
                "Named after Tennessee, USA."));
        addElement(new Element("Og", "Oganesson", 118, 294.000, "18", "7", "Noble Gas",
                new String[]{"Research", "Nuclear research"},
                "Named after Yuri Oganessian, heaviest known element."));
    }
}

