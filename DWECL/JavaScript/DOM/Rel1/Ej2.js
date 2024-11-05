const elem = document.body;

        // 1. Number of links on the page
        const links = elem.getElementsByTagName("a");
        console.log("Number of links: " + links.length);

        // 2. Address to which the penultimate link links to
        let penultimate = links[links.length - 2];
        console.log("The penultimate link goes to: " + penultimate.href);

        // 3. Number of links linking to the institute's website
        // let iesbelen = Array.from(links).filter(l => l.href.includes("https://iesbelen.org/")).length;

        let iesbelen = elem.querySelectorAll("a[href='https://iesbelen.org/']").length;

        /* let iesbelen = (links) => {
            let cont = 0;
            let nlinks = Array.from(links);
            nlinks.forEach(e => {
                if (e.href === "https://iesbelen.org/") {
                    cont++;
                }
            })
            return cont;
        } */

        console.log("Links to the institute's website: " + iesbelen);
        // console.log("Links to the institute's website: " + iesbelen(links));
        // console.log(typeof iesbelen);

        // 4. Number of links in the third paragraph
        const links3P = elem.getElementsByTagName("p")[2].getElementsByTagName("a").length;
        console.log("There are " + links3P + " links in the third paragraph");